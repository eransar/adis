package view;

import Contrroller.Handlers.CloseStageHandler;
import Contrroller.Handlers.PayPalEventHandler;
import Contrroller.MasterController;
import Entities.User;
import Entities.Vacation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

public class Payment implements Initializable{

    @FXML
public ToggleGroup payment;
public AnchorPane anchor_bg;
public Vacation currentVacation;

    public void setCurrentVacation(Vacation currentVacation) {
        this.currentVacation = currentVacation;
    }

    //paypal
   public AnchorPane paypal_anchor;
   public TextField paypal_username;
   public PasswordField paypal_password;
   public Label paypal_price;
   public Button paypal_pay;



   //credit card
   public AnchorPane credit_anchor;
   public TextField credit_number;
   public  TextField credit_id;
   public ComboBox<Integer> credit_year;
   public  ComboBox<Integer> credit_month;
   public TextField credit_cvv;
   public Label credit_price;
   public Button credit_pay;
   public User user;
   public MasterController mc;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc = MasterController.getInstance();
        ToggleGroupListener();
        fillyears();
        fillmonths();
        user = new User("");



    }
    public void fillyears(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        ArrayList<Integer> years = new ArrayList<>();
        for (int i = year; i < year +6 ; i++) {
            years.add(i);
        }
        credit_year.setItems(FXCollections.observableArrayList(years));
    }
    public void fillmonths(){
        ArrayList<Integer> months = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            months.add(i);
        }
        credit_month.setItems(FXCollections.observableArrayList(months));

    }

    private void ToggleGroupListener() {
        payment.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (payment.getSelectedToggle() != null) {
                    RadioButton selectedRadioButton = (RadioButton) payment.getSelectedToggle();

                    switch (selectedRadioButton.getId()){
                        case "paypal":
                            credit_anchor.setVisible(false);
                            paypal_anchor.setVisible(true);
                            anchor_bg.setVisible(true);
                            paypal_pay.addEventHandler(MouseEvent.MOUSE_CLICKED, new PayPalEventHandler(currentVacation,mc.getUser().getUsername(),"Paypal"));
                            break;

                        case "creditcard":
                            credit_anchor.setVisible(true);
                            paypal_anchor.setVisible(false);
                            anchor_bg.setVisible(true);
                            credit_pay.addEventHandler(MouseEvent.MOUSE_CLICKED, new PayPalEventHandler(currentVacation,mc.getUser().getUsername(),"Paypal"));
                            break;
                    }



                    // Do something here with the userData of newly selected radioButton

                }



            }
        });
    }
    public void paypal_onclick(){
        paypal_pay.addEventHandler(MouseEvent.MOUSE_CLICKED, new PayPalEventHandler(currentVacation,mc.getUser().getUsername(),"Paypal"));
    }
    public void credit_onclick(){

    }
}
