package Contrroller;

import Entities.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {

    public Label home;
    public TextField name;
    public TextField last;
    public TextField city;
    public TextField birth;
    public TextField userPro;
    public TextField pass;
    public Button updateUser;

    Model model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.model = Model.getInstance();
        name.setText(MainController.getUser().getFirst_name());
        last.setText(MainController.getUser().getLast_name());
        city.setText(MainController.getUser().getCity());
        birth.setText(MainController.getUser().getBirth());
        userPro.setText(MainController.getUser().getUsername());
        pass.setText(MainController.getUser().getPassword());
        userPro.setDisable(true);
    }

    public void updateProfile(ActionEvent event){
        User user = new User(userPro.getText(),pass.getText(),birth.getText(),city.getText(),name.getText(),last.getText());
        MainController.setUser(user);
        model.update(user);
    }

}
