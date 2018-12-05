package view;

import Contrroller.MasterController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowVacation implements Initializable {

    private MasterController mc;

    @FXML
    public AnchorPane a0;
    public AnchorPane a1;
    public AnchorPane a2;
    public AnchorPane a3;
    public AnchorPane a4;
    public Button b1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc = MasterController.getInstance();
    }

    public void clickOnVacation(javafx.event.ActionEvent event) {

    }
}
