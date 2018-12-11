package view;

import Contrroller.Handlers.CloseStageHandler;
import Contrroller.Handlers.PayPalEventHandler;
import Contrroller.MasterController;
import Entities.Payment;
import Entities.Transaction;
import Entities.User;
import Entities.Vacation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class Payments implements Initializable{

    @FXML
public ToggleGroup payment;
public AnchorPane anchor_bg;



    public static Transaction currenttransaction;
public static Vacation currentVacation;
boolean pay;
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

   public Label error;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc = MasterController.getInstance();
        this.pay=false;
        ToggleGroupListener();
        fillyears();
        fillmonths();
        user = mc.getUser();



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
                            break;

                        case "creditcard":
                            credit_anchor.setVisible(true);
                            paypal_anchor.setVisible(false);
                            anchor_bg.setVisible(true);

                            break;
                    }




                }



            }
        });
    }
    public void paypal_onclick(ActionEvent event) throws InterruptedException {
        if(paypal_username.getText().isEmpty() || paypal_password.getText().isEmpty()){

            error.setVisible(true);
            error.setText("Please fill username and password");
        }
        else{
            mc.insert(new Payment(mc.getMax(new Payment())+1,currentVacation.getCreator(),mc.getUser().getUsername(),currentVacation.getPrice(),Integer.parseInt(currentVacation.getVacation_id()),0,"","",LocalDate.now().toString(),"paypal",paypal_username.getText()));
            mc.update(new Transaction(Integer.parseInt(currenttransaction.getTransaction_id()),currenttransaction.getSeller(),currenttransaction.getBuyer(),currenttransaction.getVacation_id(),"3"));
            showAlert("Thank you for purchasing "+currentVacation.getVacation_id()
                    +" To"+currentVacation.getLocation()+" "+System.lineSeparator()
                    +" By Paying "+currentVacation.getPrice()+System.lineSeparator()
                    +"Enjoy your vacation");


            ((Node)(event.getSource())).getScene().getWindow().hide();

        }

    }
    public void credit_onclick(ActionEvent event) throws InterruptedException {
        pay=true;
        if(        credit_month.getSelectionModel().isEmpty()
                || credit_year.getSelectionModel().isEmpty()
                || credit_cvv.getText().isEmpty()
                || credit_id.getText().isEmpty()
                || credit_number.getText().isEmpty()){

            error.setVisible(true);
            error.setText("Please fill all of the fields below");
            pay=false;
        }
        if(credit_id.getText().length() != 9 || !isAllnumbers(credit_id.getText())){
            error.setVisible(true);
            error.setText("ID length must be 9 digits long");
            pay=false;
        }

        if(credit_cvv.getText().length() !=3 || !isAllnumbers(credit_cvv.getText())){
            error.setVisible(true);
            error.setText("Credit CVV must be 3 digits long");
            pay=false;
        }

        if(!isAllnumbers(credit_number.getText())){
            error.setVisible(true);
            error.setText("Credit card must contain only digits");
            pay=false;
        }


        if(pay){
            mc.insert(new Payment(mc.getMax(new Payment())+1,currentVacation.getCreator(),mc.getUser().getUsername(),currentVacation.getPrice(),Integer.parseInt(currentVacation.getVacation_id()),
                    Integer.parseInt(credit_id.getText()),credit_cvv.getText(),credit_month.getSelectionModel().getSelectedItem().toString()+" "+credit_year.getSelectionModel().getSelectedItem().toString(), LocalDate.now().toString(),"credit",""));
            mc.update(new Transaction(Integer.parseInt(currenttransaction.getTransaction_id()),currenttransaction.getSeller(),currenttransaction.getBuyer(),currenttransaction.getVacation_id(),"3"));


            showAlert("Thank you for purchasing "+"Vacation number "+currentVacation.getVacation_id()
                    +" To "+currentVacation.getLocation()+" "+System.lineSeparator()
                    +" By Paying "+currentVacation.getPrice()+System.lineSeparator()
                    +"Enjoy your vacation");
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }

    }
    public void setcurrentvacation(Vacation v){
        this.currentVacation=v;
    }


    public boolean isAllnumbers(String text){
        String regex = "[0-9]+";
        if(text.matches(regex)){
            return true;
        }

        return false;
    }

    public void showAlert(String alert){
        Alert alert_ = new Alert(Alert.AlertType.CONFIRMATION);
        alert_.setTitle("Payment Massage");
        alert_.setHeaderText("Payment Message");
        alert_.setContentText(alert);
        alert_.showAndWait();
    }

    public static void setCurrenttransaction(Transaction currenttransaction) {
        Payments.currenttransaction = currenttransaction;
    }
}
