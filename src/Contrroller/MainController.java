package Contrroller;

import Contrroller.Handlers.LoginHandler;
import Entities.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Model model;
    public Button button_LogIN;
    public Button button_SignUp;
    public Button button_Search;
    public TextField firstName;
    public TextField lastName;
    public TextField city;
    public TextField birthday;
    public TextField userName;
    public PasswordField password;
    public TextField logIn_User;
    public TextField logIn_Password;
    public TextField search;
    public ChoiceBox<String> search_options;
    public AnchorPane searchAncer;
    public Label unCorrect;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        MainController.user = user;
    }

    private static User user;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = Model.getInstance();
        unCorrect.setVisible(false);
        try {
            Search();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void BuildUserEntity(){
        this.user=new User(
                userName.getText(),
                password.getText(),
                birthday.getText(),
                city.getText(),
                firstName.getText(),
                lastName.getText()
        );

    }
    /*
    log to user
     */
    public void LogInClick(ActionEvent event) throws IOException {
        User userLoginCheck = new User(logIn_User.getText(),logIn_Password.getText(),"","","","");
        ArrayList<String> loginList = model.login(userLoginCheck);
        if(loginList.size() == 0){
            unCorrect.setVisible(true);
        }
        else{
            User userLogin = new User(loginList);
            MainController.setUser(userLogin);
            button_LogIN.addEventHandler(MouseEvent.MOUSE_CLICKED, new LoginHandler());
            setSign_up();

        }
//        unCorrect.setVisible(false);
    }

    /*
        create new user
     */
    public void RegisterClick(ActionEvent actionEvent) throws IOException {
        button_SignUp.addEventHandler(MouseEvent.MOUSE_CLICKED, new LoginHandler());
        BuildUserEntity();
        model.InsertToDB(user);


        //setSign_up();
//    model.Insert();
    }

    /*
        search fxml
     */
    public void Search() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Search.fxml"));
        searchAncer.getChildren().setAll(pane);
    }

    /*
        set sign up -
     */
    public void setSign_up() throws IOException{
        button_SignUp.addEventHandler(MouseEvent.MOUSE_CLICKED, new LoginHandler());
    }
}
