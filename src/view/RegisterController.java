package view;

import Entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable{
@FXML
    public Button sign_up;
    public TextField firstname;
    public TextField lastname;
    public TextField city;
    public TextField birthday;
    public TextField username;
    public PasswordField password;

    Model model;
    User user;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.model=Model.getInstance();
    }

    public void BuildUserEntity(){
        this.user=new User(
                username.getText(),
                password.getText(),
                birthday.getText(),
                city.getText(),
                firstname.getText(),
                lastname.getText()
        );

    }

    public void RegisterClick(ActionEvent actionEvent) throws IOException {
//    model.Insert();
    }


}

