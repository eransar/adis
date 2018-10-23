package Contrroller;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable {
    public ChoiceBox<String> search_options;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set ChoiceSearch
        search_options.setValue("User");
        search_options.getItems().addAll("User");
    }
}
