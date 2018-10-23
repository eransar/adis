package Contrroller;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable {
    public ChoiceBox<String> search_options;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        search_options = new ChoiceBox<>(FXCollections.observableArrayList("User"));
    }

    public void Choice(MouseEvent event){

    }
}
