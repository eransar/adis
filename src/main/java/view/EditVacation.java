package view;

import Contrroller.Handlers.CRUDvacationHandler;
import Contrroller.Handlers.CloseStageHandler;
import Contrroller.MasterController;
import Entities.Vacation;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public Label edit_error;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        edit_location.setText(vacations.getLocation());
        edit_start.setText(vacations.getStart_date());
        edit_end.setText(vacations.getEnd_date());
        edit_price.setText(vacations.getPrice());
        edit_freeText.setText(vacations.getText());
        edit_start.setDisable(true);
        edit_end.setDisable(true);
    }

    public static Vacation getVacations() {
        return vacations;
    }

    public static void setVacations(Vacation vacations) {
        EditVacation.vacations = vacations;
    }

    public void save(ActionEvent event){

        if(!isAllnumbers(edit_price.getText())){
        edit_error.setText("Price must contain number only");
        }
        else{
            Vacation vacation = new Vacation(Integer.parseInt(vacations.getVacation_id()),vacations.getCreator(),edit_location.getText(),vacations.getAirline(),edit_price.getText(),edit_start.getText(),edit_end.getText(),"","1",edit_freeText.getText());
            mc.update(vacation);
            edit_buttonSave.addEventHandler(MouseEvent.MOUSE_CLICKED, new CloseStageHandler());
        }

    }

    public boolean isAllnumbers(String text){
        String regex = "[0-9]+";
        if(text.matches(regex)){
            return true;
        }

        return false;
    }

}
