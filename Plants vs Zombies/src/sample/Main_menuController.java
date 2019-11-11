package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main_menuController {
    
    @FXML private Button Play_Game_Button;
    
    @FXML private Button Tutorial_Button;

    @FXML private Button Load_Game_Button;

    @FXML private Button Almanac_Button;

    @FXML private Button Exit_Button;

    @FXML private ImageView Play_Game;

    @FXML private ImageView Tutorial;

    @FXML private ImageView Load_Game;

    @FXML private ImageView Exit;

    @FXML private ImageView Almanac;



    public void Play_Game_Hover_Enter()
    {
        Play_Game.setImage(new Image( getClass().getResourceAsStream("../Images/Main Menu/homescreenbutton3 (2).png") ));
    }

    public void Play_Game_Hover_Exit()
    {
        Play_Game.setImage(new Image(getClass().getResourceAsStream("../Images/Main Menu/homescreenbutton3.png")));
    }

    public void Tutorial_Hover_Enter()
    {
        Tutorial.setImage(new Image( getClass().getResourceAsStream("../Images/Main Menu/homescreenbutton2 (2).png") ));
    }

    public void Tutorial_Hover_Exit()
    {
        Tutorial.setImage(new Image(getClass().getResourceAsStream("../Images/Main Menu/homescreenbutton2.png")));
    }

    public void Load_Game_Hover_Enter()
    {
        Load_Game.setImage(new Image( getClass().getResourceAsStream("../Images/Main Menu/homescreenbutton5 (2).png") ));
    }

    public void Load_Game_Hover_Exit()
    {
        Load_Game.setImage(new Image(getClass().getResourceAsStream("../Images/Main Menu/homescreenbutton5.png")));
    }

    public void Almanac_Hover_Enter()
    {
        Almanac.setImage(new Image( getClass().getResourceAsStream("../Images/Main Menu/homescreenbutton6 (2).png") ));
    }

    public void Almanac_Hover_Exit()
    {
        Almanac.setImage(new Image(getClass().getResourceAsStream("../Images/Main Menu/homescreenbutton6.png")));
    }

    public void Exit_Hover_Enter()
    {
        Exit.setImage(new Image( getClass().getResourceAsStream("../Images/Main Menu/homescreenbutton1 (2).png") ));
    }

    public void Exit_Hover_Exit()
    {
        Exit.setImage(new Image(getClass().getResourceAsStream("../Images/Main Menu/homescreenbutton7.png")));
    }

    public void Almanac_button_clicked()
    {
        Stage myStage = (Stage) Almanac.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/Almanac.fxml"));
        Pane myPane = null;
        try {
            myPane = (Pane) loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Almanac Button Pressed      " + myPane);
        myStage.setScene(new Scene(myPane, 1280, 720));
    }

    public void Play_button_clicked()
    {
        Stage myStage = (Stage) Play_Game.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/Game_Screen.fxml"));
        ScrollPane myPane = null;
        try {
            myPane = (ScrollPane) loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Play Button Pressed      " + myPane);
        myStage.setScene(new Scene(myPane, 1280, 720));
    }
}
