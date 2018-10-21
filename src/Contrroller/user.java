package Contrroller;

import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class user implements Initializable {

    public Circle profileImage;

    public void initialize(URL location, ResourceBundle resources) {
        profileImage.setStroke(Color.SEAGREEN);
        Image im = new Image("images/sumemrfun.jpg",false);
        profileImage.setFill(new ImagePattern((im)));
        profileImage.setEffect(new DropShadow(+25d ,0d,+2d,Color.DARKGREEN));
    }


}
