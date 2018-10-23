package Contrroller;

import Entities.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Model;

import java.io.IOException;
import java.net.URL;
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

    public void LogInClick(){
        System.out.println(logIn_User.getText());
        System.out.println(logIn_Password.getText());
    }

    public void RegisterClick(ActionEvent actionEvent) throws IOException {
        BuildUserEntity();
        model.InsertToDB(user);
        System.out.println("oooo");
        setSign_up();
//    model.Insert();
    }

    public void setSign_up() throws IOException{
        button_SignUp.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                LogInClick();
                Parent a = null;
                try {
                    a = FXMLLoader.load(getClass().getResource("/view/userConnected.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Scene scene = new Scene(a);
                scene.getStylesheets().add(getClass().getResource("/view/mainWin.css").toExternalForm());
                Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
                s.setScene(scene);
                s.show();
                


            }
        });
    }


}
