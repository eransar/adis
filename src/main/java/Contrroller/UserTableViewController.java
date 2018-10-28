package Contrroller;

import Entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UserTableViewController implements Initializable {
    @FXML
    public TableView<User> table;
    public TableColumn<User,String> username;
    public TableColumn<User,String> password;
    public TableColumn<User,String> firstname;
    public TableColumn<User,String> lastname;
    public TableColumn<User,String> city;
    public TableColumn<User,String> birth;
    public TableColumn<User,String> picture;
    public AnchorPane tableAnchor;

    ObservableList<User> data = FXCollections.observableArrayList(Search.getUsers());



    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Search.setUsers();
        username.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
        birth.setCellValueFactory(new PropertyValueFactory<User,String>("birth"));
//        password.setCellValueFactory(new PropertyValueFactory<User,String>("password"));
        firstname.setCellValueFactory(new PropertyValueFactory<User,String>("first_name"));
        lastname.setCellValueFactory(new PropertyValueFactory<User,String>("last_name"));
        city.setCellValueFactory(new PropertyValueFactory<User,String>("city"));
        table.setItems(data);
//      picture.setCellValueFactory(new PropertyValueFactory<User,String>("picture"));
    }
}
