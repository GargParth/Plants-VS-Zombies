package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.concurrent.TimeUnit;

public class Main extends Application {

    private Scene scene;

    public void setScene(Scene newScene){
        this.scene = newScene;
    }

    public Scene getScene() {
        return scene;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/loading_screen.fxml"));
        Pane root = (Pane) loader.load();
        primaryStage.setTitle("Plants V/S Zombies");
        primaryStage.setResizable(false);
        setScene(new Scene(root, 1280, 720 ));
        primaryStage.show();
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
