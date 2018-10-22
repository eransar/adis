package Contrroller;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {

    public Label home;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void Home() throws IOException {
        home.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent a = null;
                try {
                    a = FXMLLoader.load(getClass().getResource("/view/userConnected.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(a);
                Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
                s.setScene(scene);
                s.show();
            }
        });
    }
}
