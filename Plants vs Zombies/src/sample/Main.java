package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class Main extends Application {

    @FXML
    private ProgressBar progress_bar;


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/loading_screen.fxml"));
        Pane root = (Pane) loader.load();
        primaryStage.setTitle("Plants V/S Zombies");

        ProgressBar pg = new ProgressBar();
        pg.setLayoutX(256);
        pg.setLayoutY(584);
        pg.setPrefWidth(768);
        pg.setPrefHeight(39);

        root.getChildren().addAll(pg);

        for(int i=0; i<=100; i++)
        {
            pg.setProgress(i/100);
            primaryStage.setScene(new Scene(root, 1280, 720));
            TimeUnit.MILLISECONDS.sleep(100);
        }
        primaryStage.setScene(new Scene(root, 1280  , 720));


        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
