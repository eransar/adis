package Contrroller.Handlers;

import Entities.Vacation;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;

public class CreditEventHandler implements EventHandler{

    final Vacation currentVacation;
    final String buyer;
    final String method;

    public CreditEventHandler(Vacation vacation, String buyer, String method){
        this.currentVacation=vacation;
        this.buyer=buyer;
        this.method=method;

    }
    @Override
    public void handle(Event event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Payment Massage");
        alert.setHeaderText("Payment Message");
        alert.setContentText("Thank you for purchasing "+currentVacation.getVacation_id()
                +" To"+currentVacation.getLocation()+" "+System.lineSeparator()
                +" By Paying "+currentVacation.getPrice()+System.lineSeparator()
                +"Enjoy your vacation");

        ((Node)(event.getSource())).getScene().getWindow().hide();

    }
}
