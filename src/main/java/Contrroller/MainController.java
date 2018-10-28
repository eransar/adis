package Contrroller;

import Contrroller.Handlers.LoginHandler;
import Entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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

        boolean register = false;

        if(
                !userName.getText().isEmpty()
                        && !password.getText().isEmpty()
                        && !firstName.getText().isEmpty()
                        && !lastName.getText().isEmpty()
                        && !city.getText().isEmpty()
                        && !birthday.getText().isEmpty())
        {
            if(
                    ((Character.isLetter(userName.getText().charAt(0))))
                            &&   (Character.isLetter(lastName.getText().charAt(0)))
                            &&   (Character.isLetter(city.getText().charAt(0)))
                            &&   (Character.isLetter(firstName.getText().charAt(0)))
                    ){

                if(
                        !city.getText().matches(".*\\d+.*")
                                &&     !firstName.getText().matches(".*\\d+.*")
                                &&     !lastName.getText().matches(".*\\d+.*")


                        ){if(password.getText().length() >=5){
                    register=true;
                }
                }

            }



        }






        if(register){
            button_SignUp.addEventHandler(MouseEvent.MOUSE_CLICKED, new LoginHandler());
            BuildUserEntity();
            model.InsertToDB(user);
        }



        //setSign_up();
//    model.Insert();
    }

    /*
        search fxml
     */
    public void Search() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/Search.fxml"));
        searchAncer.getChildren().setAll(pane);
    }

    /*
        set sign up -
     */
    public void setSign_up() throws IOException{
        button_SignUp.addEventHandler(MouseEvent.MOUSE_CLICKED, new LoginHandler());
    }
}
