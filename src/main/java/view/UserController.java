package view;


import Contrroller.Handlers.CRUDvacationHandler;
import Contrroller.Handlers.LoginHandler;
import Contrroller.MasterController;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable, IView {

    public Circle profileImage;
    public Label Profile;
    public AnchorPane winS;
    public Label userLabel;
    private MasterController mc;
    public ImageView post_vacation;
    public ImageView imageButton_myPost;


    public void initialize(URL location, ResourceBundle resources) {
        //Image Profile
        mc = MasterController.getInstance();
        profileImage.setStroke(Color.SEAGREEN);
        Image im = new Image("images/profile.png",false);
        profileImage.setFill(new ImagePattern((im)));
        profileImage.setEffect(new DropShadow(+25d ,0d,+2d,Color.SNOW));
        userLabel.setText(mc.getUser().getUsername());
        imageHandle();
        //Search Scene
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("/Search.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        winS.getChildren().setAll(pane);
    }

    /*
    open sub scene in the user fxml that use as menu
     */
    public void SubScene(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/Profile.fxml"));
        winS.getChildren().setAll(pane);
    }
    /*
    open home scene in the user fxml
     */
    public void HomeScene(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/Search.fxml"));
        winS.getChildren().setAll(pane);

    }

    public void activitis(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/Activitis.fxml"));
        winS.getChildren().setAll(pane);
    }

    //post vacation
    //split
    public void imageHandle() {
        post_vacation.addEventHandler(MouseEvent.MOUSE_CLICKED, new CRUDvacationHandler("CreateVacation.fxml"));
        imageButton_myPost.addEventHandler(MouseEvent.MOUSE_CLICKED, new CRUDvacationHandler("showUserVacation.fxml"));
    }
    /*
    log out screen
     */
    public void LogOut(MouseEvent event) throws IOException {
        Parent a = FXMLLoader.load(getClass().getResource("/MainWin.fxml"));
        Scene scene = new Scene(a);
        scene.getStylesheets().add(getClass().getResource("/mainWin.css").toExternalForm());
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
