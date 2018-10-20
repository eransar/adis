package view;

import Entities.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    public ImageView back;

    Model model;
    User user;
    Stage stage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.model=Model.getInstance();
        try {
            BackButtonListener();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }

    public void BackButtonListener() throws IOException{
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                //TODO Switch scene to home
            }
        });
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
        BuildUserEntity();
        model.InsertToDB(user);
//    model.Insert();
    }


}

