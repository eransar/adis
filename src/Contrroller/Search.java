package Contrroller;

import Entities.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Model;

import javax.xml.soap.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Search implements Initializable {
    public ChoiceBox<String> search_options;
    public TextField field_search;
    private Model model;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set ChoiceSearch
        search_options.setValue("user");
        search_options.getItems().addAll("user");
         model = Model.getInstance();
    }
    public void Search_click(ActionEvent actionEvent){
        ArrayList<String> result = new ArrayList<String>();
        if(search_options.getValue().equals("user")){
            User u = new User(field_search.getText());
            result=model.ReadFromDB(u,"username",field_search.getText());
            System.out.println(result.get(0));
        }

    }
}
