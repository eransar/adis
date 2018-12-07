package view;

import Contrroller.Handlers.LoginHandler;
import Contrroller.MasterController;
import Entities.User;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    public Button button_SignUpSearch;
    public AnchorPane anchor_header;
    public ComboBox<String> combo_search;
    public JFXDatePicker vacation_startdate;
    public JFXDatePicker vacation_enddate;
    public JFXTextField vacation_price;
    public JFXTextField vacation_location;







    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        MainController.user = user;
    }

    private static User user;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchor_header.setId("anchor_header");
        searchAncer.setId("searchAncer");
        combo_search.getItems().addAll("User","Vacation");
        unCorrect.setVisible(false);
        try {
            Search();
        } catch (IOException e) {
            e.printStackTrace();
        }
        date_before_18_years=LocalDate.now().minusYears(18);
//        button_SignUpSearch.setVisible(false);

//        LocalDate currentDate = LocalDate.now();
//         date_before_18_years = Date.from(currentDate.minusYears(18).atStartOfDay(ZoneId.systemDefault()).toInstant());
        //System.out.println(date_before_18_years);
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
    }

    public void set_searchComboBox(){
        System.out.println(combo_search.getSelectionModel().getSelectedItem());
        if(combo_search.getSelectionModel().getSelectedItem().equals("Vacation")){
            vacation_price.setVisible(true);
            vacation_location.setVisible(true);
            vacation_enddate.setVisible(true);
            vacation_startdate.setVisible(true);
        }
        else{
            vacation_price.setVisible(false);
            vacation_location.setVisible(false);
            vacation_enddate.setVisible(false);
            vacation_startdate.setVisible(false);
        }
//
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
    public void setSign_up() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Signup.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root, 410  , 460);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("Signup.css").toExternalForm());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Vacation4u Sign Up");
        stage.setScene(scene);
        stage.showAndWait();


    }


    @Override
    public void setCurrentView() {
        mc.setIview(this);
    }
}
