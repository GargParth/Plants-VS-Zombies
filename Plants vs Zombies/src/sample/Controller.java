package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Controller implements Initializable {

    @FXML
    private ProgressBar progress_bar;

    public static ProgressBar pb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pb = progress_bar;
    }

}
