package Contrroller.Handlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginHandler implements EventHandler {


    @Override
    public void handle(Event event) {
        System.out.println("a");
        Parent a = null;
        try {
            a = FXMLLoader.load(getClass().getResource("/view/userConnected.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(a);
        scene.getStylesheets().add(getClass().getResource("/view/mainWin.css").toExternalForm());
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.setScene(scene);
        s.show();
    }
}
