package view;

import Contrroller.Handlers.CloseStageHandler;
import Contrroller.MasterController;
import Entities.Vacation;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditVacation implements Initializable{

    private MasterController mc = MasterController.getInstance();
    public static Vacation vacations;
    @FXML
    public TextField edit_location;
    public TextField edit_start;
    public TextField edit_end;
    public TextField edit_price;
    public TextArea edit_freeText;
    public ImageView edit_image;
    public Button edit_buttonSave;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        edit_location.setText(vacations.getLocation());
        edit_start.setText(vacations.getStart_date());
        edit_end.setText(vacations.getEnd_date());
        edit_price.setText(vacations.getPrice());
        edit_freeText.setText(vacations.getText());
    }

    public static Vacation getVacations() {
        return vacations;
    }

    public static void setVacations(Vacation vacations) {
        EditVacation.vacations = vacations;
    }

    public void save(ActionEvent event){
        Vacation vacation = new Vacation(Integer.parseInt(vacations.getVacation_id()),vacations.getCreator(),edit_location.getText(),vacations.getAirline(),edit_price.getText(),edit_start.getText(),edit_end.getText(),"","true",edit_freeText.getText());
        mc.update(vacation);
        edit_buttonSave.addEventHandler(MouseEvent.MOUSE_CLICKED, new CloseStageHandler());
    }

}
