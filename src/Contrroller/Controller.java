package Contrroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Controller extends Observable implements Observer {


    private Model model;
    private Stage stage;

    public void init(Stage stage){
        this.stage=stage;
        this.model= Model.getInstance();
    }


    public void RegisterClick(ActionEvent actionEvent) throws IOException {
        Parent a = FXMLLoader.load(getClass().getResource("/view/Register.fxml"));
        Scene scene = new Scene(a);
        Stage s = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s.setScene(scene);
        s.show();
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
