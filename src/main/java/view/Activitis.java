package view;

import Contrroller.Handlers.ActivitiesHandler;
import Contrroller.Handlers.CRUDvacationHandler;
import Contrroller.MasterController;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Activitis implements Initializable{

    public ImageView payment;
    public ImageView your_approval;
    public ImageView seller_approval;
    private MasterController mc = MasterController.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ButtonCLick();
    }

    public void ButtonCLick(){
        payment.addEventHandler(MouseEvent.MOUSE_CLICKED, new ActivitiesHandler(""));
        your_approval.addEventHandler(MouseEvent.MOUSE_CLICKED, new ActivitiesHandler("UserApprove.fxml"));
        seller_approval.addEventHandler(MouseEvent.MOUSE_CLICKED, new ActivitiesHandler(""));
    }
}
