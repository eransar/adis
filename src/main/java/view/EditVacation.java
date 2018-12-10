package view;

import Contrroller.MasterController;
import Entities.Vacation;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditVacation implements Initializable{

    private MasterController mc = MasterController.getInstance();
    public static Vacation vacations;
    @FXML
    public TextArea edit_location;
    public TextArea edit_start;
    public TextArea edit_end;
    public TextArea edit_price;
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

    public void save(){
        Vacation vacation = new Vacation(vacations.getCreator(),edit_location.getText(),vacations.getAirline(),edit_price.getText(),edit_start.getText(),edit_end.getText(),vacations.getPicture(),"true",edit_freeText.getText());
        mc.update(vacation);
    }

}
