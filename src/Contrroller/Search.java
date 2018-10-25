package Contrroller;

import Entities.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Model;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Search implements Initializable {
    public ChoiceBox<String> search_options;
    public TextField field_search;
    public AnchorPane tablepane;
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
    }
    public void Search_click(ActionEvent actionEvent) throws IOException {

        if(search_options.getValue().equals("user")){
             search_user = new User(field_search.getText());
            result=model.ReadFromDB(search_user,"username",field_search.getText());
            System.out.println(result.get(0));
        }
        Users=listToUser(result);

        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/UserTableView.fxml"));
        tablepane.getChildren().setAll(pane);
    }
    public ArrayList<User> listToUser(ArrayList<String> arrayList){

        ArrayList<String> temp = new ArrayList<>();
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
