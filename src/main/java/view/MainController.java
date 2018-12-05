package view;

import Contrroller.Handlers.LoginHandler;
import Contrroller.MasterController;
import Entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable, IView {

    @FXML

    private MasterController mc = MasterController.getInstance();
//    private Date date_before_18_years;
    private LocalDate date_before_18_years;
    public Button button_LogIN;
    public Button button_SignUp;
    public Button button_Search;
    public TextField firstName;
    public TextField lastName;
    public TextField city;
    public DatePicker birthday;
    public TextField userName;
    public PasswordField password;
    public TextField logIn_User;
    public TextField logIn_Password;
    public TextField search;
    public ChoiceBox<String> search_options;
    public AnchorPane searchAncer;
    public Label unCorrect;
    public Label error_signup;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        MainController.user = user;
    }

    private static User user;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        unCorrect.setVisible(false);
        try {
            Search();
        } catch (IOException e) {
            e.printStackTrace();
        }
        date_before_18_years=LocalDate.now().minusYears(18);

//        LocalDate currentDate = LocalDate.now();
//         date_before_18_years = Date.from(currentDate.minusYears(18).atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(date_before_18_years);
    }

    public void BuildUserEntity(){
        this.user=new User(
                userName.getText(),
                password.getText(),
                birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
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
        ArrayList<String> loginList = mc.login(userLoginCheck);

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
        boolean date = true;
        try {
            String test =birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            date=false;
        }

        if(
                !userName.getText().isEmpty()
                        && !password.getText().isEmpty()
                        && !firstName.getText().isEmpty()
                        && !lastName.getText().isEmpty()
                        && !city.getText().isEmpty()
                        && date )

        {



            if(((Character.isLetter(userName.getText().charAt(0))))
                            &&   (Character.isLetter(lastName.getText().charAt(0)))
                            &&   (Character.isLetter(city.getText().charAt(0)))
                            &&   (Character.isLetter(firstName.getText().charAt(0))))
            {



                if(!city.getText().matches(".*\\d+.*")
                                &&     !firstName.getText().matches(".*\\d+.*")
                                &&     !lastName.getText().matches(".*\\d+.*"))
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
            button_SignUp.addEventHandler(MouseEvent.MOUSE_CLICKED, new LoginHandler());
            BuildUserEntity();
            mc.insert(user);
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

    @Override
    public void setCurrentView() {
        mc.setIview(this);
    }
}
