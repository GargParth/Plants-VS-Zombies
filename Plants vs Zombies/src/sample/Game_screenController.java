package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Game_screenController implements Initializable {

    @FXML private ScrollPane BG_scroller;

    @FXML private GridPane Game_Grid;

    @FXML private Pane seed_container_pane;

    @FXML private ImageView game_text;

    @FXML private GridPane seed_packet_grid;

    @FXML private ImageView sun_counter_display;

    @FXML private Pane normal_pane;

    @FXML private ChoiceBox<String> in_game_menu;

    private boolean seed_selected;
    private StackPane grid_stack;
    private ImageView selected_plant;
    private String Plant_sprite;
    int which_seed_to_reset;
    String reset_sprite;

    private ImageView test;


    public void pan_background() throws InterruptedException {
        Timeline scroll = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(BG_scroller.hvalueProperty(), BG_scroller.getHmax())
                ),
                new KeyFrame(
                        Duration.seconds(1),
                        new KeyValue(BG_scroller.hvalueProperty(), 0)
                )
        );
        Timeline Revscroll = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(BG_scroller.hvalueProperty(), 0)
                ),
                new KeyFrame(
                        Duration.seconds(1),
                        new KeyValue(BG_scroller.hvalueProperty(), BG_scroller.getHmax())
                )
        );
        Revscroll.playFromStart();
        Revscroll.setOnFinished(event ->
        {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scroll.playFromStart();

            scroll.setOnFinished(event1 -> {

                Timeline game_start_text = new Timeline(
                        new KeyFrame(
                                Duration.millis(400),
                                new KeyValue(game_text.imageProperty(), new Image(getClass().getResourceAsStream("../Images/Text/StartReady.png"))),
                                new KeyValue(game_text.visibleProperty(), true)
                        ),
                        new KeyFrame(
                                Duration.millis(1200),
                                new KeyValue(game_text.imageProperty(), new Image(getClass().getResourceAsStream("../Images/Text/StartSet.png")))
                        ),
                        new KeyFrame(
                                Duration.millis(2000),
                                new KeyValue(game_text.imageProperty(), new Image(getClass().getResourceAsStream("../Images/Text/StartPlant.png")))
                        ),
                        new KeyFrame(
                                Duration.millis(2800),
                                new KeyValue(game_text.visibleProperty(), false)
                        )
                );

                game_start_text.playFromStart();

                game_start_text.setOnFinished(event2 -> {
                    seed_container_pane.setVisible(true);
                    sun_counter_display.setVisible(true);
                });
            });
        });
    }

    public void Load_seedPackets()
    {
        test = new ImageView();
        test.setImage(new Image(getClass().getResourceAsStream("../Images/GameScreen/seedpacket_sunflower.png")));
        test.setFitHeight(75);
        test.setFitWidth(110);
        seed_packet_grid.add(test, 0 ,0);
        test.setOnMouseClicked(event -> {
            click_sunflower_seed();
        });

        test = new ImageView();
        test.setImage(new Image(getClass().getResourceAsStream("../Images/GameScreen/seedpacket_peashooter.png")));
        test.setFitHeight(75);
        test.setFitWidth(110);
        seed_packet_grid.add(test, 0 ,1);
        test.setOnMouseClicked(event -> {
            click_peashooter_seed();
        });
    }

    public void click_sunflower_seed()
    {
        ImageView sun_seed = (ImageView) seed_packet_grid.getChildren().get(0);
        sun_seed.setImage(new Image(getClass().getResourceAsStream("../Images/GameScreen/clickedseedpacket_sunflower.png")));
        sun_seed.setFitHeight(75);
        sun_seed.setFitWidth(110);
        seed_selected = true;
        Plant_sprite = "../Images/GameScreen/anim_sunflower.gif";
        which_seed_to_reset = 0;
        reset_sprite = "../Images/GameScreen/seedpacket_sunflower.png";
    }

    public void click_peashooter_seed()
    {
        ImageView peashooter_seed = (ImageView) seed_packet_grid.getChildren().get(1);
        peashooter_seed.setImage(new Image(getClass().getResourceAsStream("../Images/GameScreen/clickedseedpacket_normalpeashooter.png")));
        peashooter_seed.setFitHeight(75);
        peashooter_seed.setFitWidth(110);
        seed_selected = true;
        Plant_sprite = "../Images/GameScreen/anim_peashooter.gif";
        which_seed_to_reset = 1;
        reset_sprite = "../Images/GameScreen/seedpacket_peashooter.png";
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        sun_counter_display.setVisible(false);
        seed_container_pane.setVisible(false);
        game_text.setVisible(false);
        seed_selected = false;
        selected_plant = new ImageView();
        selected_plant.setVisible(false);

        Load_seedPackets();
        try {
            pan_background();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for ( int i=0; i<5; i++ )
        {
            test = new ImageView();
            test.setImage(new Image(getClass().getResourceAsStream("../Images/GameScreen/lawnmower.png")));
            test.setFitWidth(82.3);
            test.setFitHeight(79.4);
            Game_Grid.add(test,0,i);
        }

        for (int i=1; i<10; i++)
        {
            for (int j=0; j<5; j++)
            {
                grid_stack = new StackPane();
                Game_Grid.add(grid_stack, i, j);

                grid_stack.setOnMousePressed(event -> {
                    if(seed_selected)
                    {
                        StackPane pressed = (StackPane) event.getSource();
                        double x = pressed.getLayoutX();
                        double y = pressed.getLayoutY();
                        if(pressed.getChildrenUnmodifiable().size()==0)
                        {
                            test = new ImageView();
                            test.setImage(new Image(getClass().getResourceAsStream(Plant_sprite)));
                            test.setFitHeight(90);
                            test.setFitWidth(85);
                            seed_selected = false;
                            pressed.getChildren().addAll(test);
                            seed_packet_grid.getChildren().removeAll(seed_packet_grid.getChildren());
                            Load_seedPackets();

                            if(which_seed_to_reset==1)
                            {
                                test = (ImageView) pressed.getChildren().get(0);
                                ImageView pea = new ImageView();
                                pea.setImage(new Image(getClass().getResourceAsStream("../Images/GameScreen/pea2.png")));
                                pea.setY(y + 150 );
                                pea.setFitHeight(20);
                                pea.setFitWidth(20);
                                pea.setX(x + 180 + 50 + 10 + 10 + 20 + 20);
                                pea.setVisible(false);
                                normal_pane.getChildren().addAll(pea);
                                pea.toFront();

                                Image p = new Image(getClass().getResourceAsStream("../Images/GameScreen/anim_peashooter_shoot.gif"));
                                Image p2 = new Image(getClass().getResourceAsStream("../Images/GameScreen/anim_peashooter.gif"));
                                Timeline pea_shot = new Timeline(
                                        new KeyFrame(
                                                Duration.ZERO,
                                                new KeyValue(pea.visibleProperty(), false),
                                                new KeyValue(pea.xProperty(), x+180+50)
                                        ),
                                        new KeyFrame(
                                                Duration.millis(1000),
                                                new KeyValue(test.imageProperty(),p)
                                        ),
                                        new KeyFrame(
                                                Duration.millis(1500),
                                                new KeyValue(test.imageProperty(),p2),
                                                new KeyValue(pea.xProperty(), x+180+50),
                                                new KeyValue(pea.visibleProperty(), true)
                                        ),
                                        new KeyFrame(
                                                Duration.millis(5200),
                                                new KeyValue(pea.xProperty(), 2200)
                                        )
                                );
                                pea_shot.playFromStart();
                            }

                        }
                    }
                });
            }
        }
        BG_scroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        in_game_menu = new ChoiceBox<String>();
        in_game_menu.setPrefWidth(174);
        in_game_menu.setPrefHeight(48);
        normal_pane.getChildren().addAll(in_game_menu);
        in_game_menu.toFront();
        in_game_menu.setLayoutX(994);
        in_game_menu.setLayoutY(46);
        in_game_menu.setOpacity(0);
        in_game_menu.getItems().addAll("SAVE and exit", "Exit without Saving", "Simply save Game");

    }
}
