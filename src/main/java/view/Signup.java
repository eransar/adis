package view;

import Contrroller.Handlers.CloseStageHandler;
import Contrroller.Handlers.LoginHandler;
import Contrroller.MasterController;
import Entities.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Signup implements Initializable{
    @FXML
    private MasterController mc;
    public AnchorPane signup_anchor;
    public Button button_signup;
    public TextField firstname;
    public TextField lastname;
    public TextField city;
    public TextField username;
    public PasswordField password;
    public DatePicker birthday;
    public Label error_signup;
    private LocalDate date_before_18_years;

    private static User user;
//    public DatePicker birthday;
//    public JFXTextField username;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc=MasterController.getInstance();
        date_before_18_years=LocalDate.now().minusYears(18);

    }


    public void BuildUserEntity(){
        this.user=new User(
                username.getText(),
                password.getText(),
                birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                city.getText(),
                firstname.getText(),
                lastname.getText()
        );
        mc.setUser(this.user);

    }


    public void RegisterClick(ActionEvent actionEvent) throws IOException {

        boolean register = false;
        boolean date = true;
        try {
            String test =birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            date=false;
        }

        if(
                !username.getText().isEmpty()
                        && !password.getText().isEmpty()
                        && !firstname.getText().isEmpty()
                        && !lastname.getText().isEmpty()
                        && !city.getText().isEmpty()
                        && date )

        {



            if(((Character.isLetter(username.getText().charAt(0))))
                    &&   (Character.isLetter(lastname.getText().charAt(0)))
                    &&   (Character.isLetter(city.getText().charAt(0)))
                    &&   (Character.isLetter(firstname.getText().charAt(0))))
            {



                if(!city.getText().matches(".*\\d+.*")
                        &&     !firstname.getText().matches(".*\\d+.*")
                        &&     !lastname.getText().matches(".*\\d+.*"))
                {

                    if(password.getText().length() >=5)
                    {
                        if(birthday.getValue().isAfter(date_before_18_years)){
                            error_signup.setText("Must be 18 years old to signup");
                            error_signup.setVisible(true);
                        }
                        else{
                            register=true;
                        }

                    }
                    else{
                        error_signup.setVisible(true);
                        error_signup.setText("password must be at least 5 letters");
                    }
                }
                else{
                    error_signup.setVisible(true);
                    error_signup.setText("Please dont use digits in first name , last name and city fields");
                }

            }
            else{
                error_signup.setVisible(true);
                error_signup.setText("The following fields can't start with a digit :"+'\n'+" Username, Last name, first name and city");
            }



        }
        else{
            error_signup.setText("One of the fields are empty");
            error_signup.setVisible(true);
        }






        if(register){
            if(mc.getData(new User(),"username",username.getText()).size() > 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System Massage");
                alert.setHeaderText("Register Massage");
                alert.setContentText("You already registered");
                alert.showAndWait();

            }
            else{
                button_signup.addEventHandler(MouseEvent.MOUSE_CLICKED, new CloseStageHandler());
                BuildUserEntity();
                mc.insert(user);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System Massage");
                alert.setHeaderText("Register Massage");
                alert.setContentText("Thank you for your Register\nNow you can Log In to your User");
                alert.showAndWait();

            }

        }


    }

}


