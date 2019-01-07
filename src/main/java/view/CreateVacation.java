package view;

import Contrroller.Handlers.CloseStageHandler;
import Contrroller.MasterController;
import Entities.Vacation;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class CreateVacation implements Initializable {
    public TextField location;
    public TextField airline;
    public TextField price;
    public DatePicker startdate;
    public DatePicker enddate;
    public ImageView Picture;
    public Button button_post;
    public TextArea text;
    public Label error;
    public MasterController mc;
    public boolean post;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc=MasterController.getInstance();
    }

    public void post(){
        boolean date=true;
        post=true;
        String start_text = null;
        String end_text = null;
        try {
            start_text = startdate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            end_text = enddate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            error.setText("Please fill start date and end date");
            date=false;
        }
        if(location.getText().equals("")
                || airline.getText().equals("")
                || price.getText().equals("")
                || (start_text!=null && start_text.equals(""))
                || (end_text!=null && end_text.equals(""))
                || text.getText().equals(""))

        {
            //if one of the fields are empty :
            error.setText("Please fill all of the fields");
            error.setVisible(true);
            post=false;
        }
        if(!isAllnumbers(price.getText())){
            error.setText("Price must contain numbers only");
            error.setVisible(true);
            post=false;
        }


        try {
            if(!date || enddate.getValue().isBefore(startdate.getValue())){
                error.setText("End date cant be before start date");
                error.setVisible(true);
                post=false;
            }

            else if(!date || startdate.getValue().isBefore(LocalDate.now())){
                error.setText("Start date cant be earlier than today");
                error.setVisible(true);
                post=false;
            }
            else{
                date=true;
            }

        } catch (Exception e) {
            error.setText("Please fill start date and end date");
            post=false;
        }

        if(post){
            button_post.addEventHandler(MouseEvent.MOUSE_CLICKED, new CloseStageHandler());
            buildVacationEntity();

        }

    }
    public void buildVacationEntity(){
        int id = mc.getMax(new Vacation())+1;
        mc.insert(new Vacation(id,mc.getUser().getUsername(),location.getText(),airline.getText()
        ,price.getText(),startdate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                enddate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),"","1",text.getText()));


    }



    public boolean isAllnumbers(String text){
        String regex = "[0-9]+";
        if(text.matches(regex)){
            return true;
        }

        return false;
    }




}
