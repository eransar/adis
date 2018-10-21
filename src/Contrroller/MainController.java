package Contrroller;

import Entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Model model;
    public Button button_LogIN;
    public Button button_SignUp;
    public Button button_Search;
    public TextField firstName;
    public TextField lastName;
    public TextField city;
    public TextField birthday;
    public TextField userName;
    public PasswordField password;
    public TextField logIn_User;
    public TextField logIn_Password;
    public TextField search;
    public ChoiceBox<String> search_options;
    private User user;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = Model.getInstance();
    }

    public void BuildUserEntity(){
        this.user=new User(
                userName.getText(),
                password.getText(),
                birthday.getText(),
                city.getText(),
                firstName.getText(),
                lastName.getText()
        );

    }
    public void RegisterClick(ActionEvent actionEvent) throws IOException {
        BuildUserEntity();
        model.InsertToDB(user);
        System.out.println("oooo");
//    model.Insert();
    }


}
