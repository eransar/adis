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
import javafx.stage.Modality;
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

    }

    public void setPayment(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("payVacation.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = null;
            scene = new Scene(root, 1200, 509);
            scene.getStylesheets().add(getClass().getClassLoader().getResource("Activities.css").toExternalForm());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOpacity(1);
            stage.setTitle("Activities");
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setYour_approval(MouseEvent event){
        ActivitiesHandler handler = new ActivitiesHandler("UserApprove.fxml",true);
        handler.handle1();
    }

    public void setSeller_approval(MouseEvent event){
        ActivitiesHandler handler = new ActivitiesHandler("UserApprove.fxml",false);
        handler.handle1();
    }
}
