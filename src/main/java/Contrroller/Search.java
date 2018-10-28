package Contrroller;

import Entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Search implements Initializable {
    public ChoiceBox<String> search_options;
    public TextField field_search;
    public AnchorPane tablepane;
    public Label noResult;
    private Model model;
    private User search_user;
    private  ArrayList<String> result;
    private static ArrayList<User> Users;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set ChoiceSearch
        result = new ArrayList<String>();
        Users = new ArrayList<User>();
        search_options.setValue("user");
        search_options.getItems().addAll("user");
         model = Model.getInstance();
         noResult.setVisible(false);
    }
    public void Search_click(ActionEvent actionEvent) throws IOException {
        if (!(field_search.getText().equals(""))) {
            if (search_options.getValue().equals("user")) {
                search_user = new User(field_search.getText());
                result = model.ReadFromDB(search_user, "username", field_search.getText());
            }
            Users = listToUser(result);
            if (result.size()>0) {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/UserTableView.fxml"));
                tablepane.getChildren().setAll(pane);
                noResult.setVisible(false);
            }
            else
                noResult.setVisible(true);
        }
    }

    private ArrayList<User> listToUser(ArrayList<String> arrayList){

        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i <arrayList.size()/search_user.getFields().size() ; i++) {
            for (int j = 0; j < search_user.getFields().size() ; j++) {
                temp.add(arrayList.get(j));
            }
            Users.add(new User(temp));
            temp.clear();
        }
        return Users;
    }

    public static ArrayList<User> getUsers() {
        return Users;
    }
}
