package view;

import Contrroller.MasterController;
import Entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable, IView {

    public Label home;
    public TextField name;
    public TextField last;
    public TextField city;
    public TextField birth;
    public TextField userPro;
    public TextField pass;
    public Button updateUser;
    private MasterController mc;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.mc = MasterController.getInstance();
        name.setText(mc.getUser().getFirst_name());
        last.setText(mc.getUser().getLast_name());
        city.setText(mc.getUser().getCity());
        birth.setText(mc.getUser().getBirth());
        userPro.setText(mc.getUser().getUsername());
        pass.setText(mc.getUser().getPassword());
        userPro.setDisable(true);
    }

    public void updateProfile(ActionEvent event){
        User user = new User(userPro.getText(),pass.getText(),birth.getText(),city.getText(),name.getText(),last.getText());
        mc.setUser(user);

        mc.update(user);
    }

    public void deleteProfile(ActionEvent event) throws IOException {
        mc.delete(mc.getUser());
        Parent a = FXMLLoader.load(getClass().getClassLoader().getResource("MainWin.fxml"));
        Scene scene = new Scene(a);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("mainWin.css").toExternalForm());
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.setScene(scene);
        s.show();
        mc.setUser(null);
    }

    @Override
    public void setCurrentView() {
        mc.setIview(this);
    }
}
