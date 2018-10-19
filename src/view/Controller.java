package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Model;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Controller extends Observable implements Observer {


    private Model model = new Model();
    private Stage stage;


    public void setStage(Stage stage){
        this.stage = stage;
    }


    public void RegisterClick(ActionEvent actionEvent) throws IOException {
        Parent a = FXMLLoader.load(getClass().getResource("/view/Register.fxml"));
        Scene scene = new Scene(a,800,400);

        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
        scene.getStylesheets().add(getClass().getResource("MyCSS.css").toExternalForm());
        stage.show();
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
