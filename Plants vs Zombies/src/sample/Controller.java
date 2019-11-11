package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.omg.CORBA.TIMEOUT;

import java.io.IOException;
import java.net.URL;
import java.security.PrivateKey;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Controller {

    @FXML
    private Label lbl;
    @FXML
    private ProgressBar progress_bar;

    private boolean pb_full = false;

    public void animate_progress_bar() throws InterruptedException
    {
        if(!pb_full)
        {
            System.out.println("HELLO");
            Timeline task = new Timeline(
                    new KeyFrame(
                            Duration.ZERO,
                            new KeyValue(progress_bar.progressProperty(), 0)
                    ),
                    new KeyFrame(
                            Duration.seconds(3),
                            new KeyValue(progress_bar.progressProperty(), 1)
                    ),
                    new KeyFrame(
                            Duration.seconds(3),
                            new KeyValue(lbl.textProperty(), "Loading Completed")
                    )
            );
            task.setCycleCount(1);
            task.playFromStart();
            pb_full=true;
            task.setOnFinished(e -> {
                Stage myStage = (Stage) progress_bar.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/User_screen.fxml"));
                Pane myPane = null;
                try {
                    myPane = (Pane) loader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                myStage.setScene(new Scene(myPane, 1280, 720));
            });
        }
    }


}
