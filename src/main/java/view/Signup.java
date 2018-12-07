package view;

import Contrroller.Handlers.LoginHandler;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Signup implements Initializable{
    @FXML
    public AnchorPane signup_anchor;
    public Button button_signup;
    public TextField firstname;
    public TextField lastname;
    public TextField city;
//    public DatePicker birthday;
//    public JFXTextField username;





    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void signup_action(){

        button_signup.addEventHandler(MouseEvent.MOUSE_CLICKED, new LoginHandler());
    }

}


