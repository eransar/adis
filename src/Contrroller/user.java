package Contrroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class user implements Initializable {

    public Circle profileImage;
    public Label Profile;
    public AnchorPane winS;

    public void initialize(URL location, ResourceBundle resources) {
        profileImage.setStroke(Color.SEAGREEN);
        Image im = new Image("images/sumemrfun.jpg",false);
        profileImage.setFill(new ImagePattern((im)));
        profileImage.setEffect(new DropShadow(+25d ,0d,+2d,Color.DARKGREEN));

    }

    /*public void ProfileFunc() throws IOException {
        Profile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                Parent a = null;
                try {
                    a = FXMLLoader.load(getClass().getResource("/view/Profile.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(a);
                scene.getStylesheets().add(getClass().getResource("/view/mainWin.css").toExternalForm());
                Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
                s.setScene(scene);
                s.show();
            }
        });
    }*/

    public void SubScene(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Profile.fxml"));
        winS.getChildren().setAll(pane);
        winS.getScene().getStylesheets().add(getClass().getResource("/view/viewCSS.css").toExternalForm());
    }


}
