package Contrroller.Handlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CRUDvacationHandler implements EventHandler {
    private  String s="";
    public CRUDvacationHandler(String ss){
        this.s = ss;
    }
    @Override
    public void handle(Event event) {
        final String s1 =s;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("showUserVacation.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root, 450, 600);
            scene.getStylesheets().add(getClass().getClassLoader().getResource("CreateVacation.css").toExternalForm());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOpacity(1);
            stage.setTitle("Post your vacation !");
            stage.setScene(scene);
            stage.showAndWait();
            event.consume();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
