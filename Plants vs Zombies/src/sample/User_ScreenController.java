package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class User_ScreenController {

    @FXML
    private Button Play_button;

    @FXML
    private TextField UserName;

    @FXML
    private ImageView Play_button_image;

    public void Play_Button_Hover_Enter()

    {
        Play_button_image.setImage(new Image( getClass().getResourceAsStream("../Images/User Screen/usercreenbutton (2).png") ));
    }

    public void Play_Button_Hover_Exit()
    {
        Play_button_image.setImage(new Image(getClass().getResourceAsStream("../Images/User Screen/userscreenbuttonnn.png")));
    }

    public void Play_Button_Clicked()
    {
        Stage myStage = (Stage) Play_button_image.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/Main_menu.fxml"));
        Pane myPane = null;
        try {
            myPane = (Pane) loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("HELLO      " + myPane);
        myStage.setScene(new Scene(myPane, 1280, 720));
    }
}
