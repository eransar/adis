package view;

import Contrroller.Handlers.CloseStageHandler;
import Contrroller.MasterController;
import Entities.Transaction;
import Entities.Vacation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ShowVacation implements Initializable {
    //list vacation
    private ArrayList<Vacation> vacation;
    private static ArrayList<Vacation> vacation_to_pick_for_trade;
    private static Vacation askforTrade;
    //mc - singleton
    private MasterController mc;
    public AnchorPane ancer_show;
    //vacation 1
    public AnchorPane ancer_1;
    public Button buttonBuy_1;
    public ImageView image_1;
    public Label price_1;
    public Label location_1;
    public Label date_1;
    public TextArea text_1;
    //vacation 2
    public AnchorPane ancer_2;
    public Button buttonBuy_2;
    public ImageView image_2;
    public Label price_2;
    public Label location_2;
    public Label date_2;
    public TextArea text_2;
    //vacation 3
    public AnchorPane ancer_3;
    public Button buttonBuy_3;
    public ImageView image_3;
    public Label price_3;
    public Label location_3;
    public Label date_3;
    public TextArea text_3;
    //vacation 4
    public AnchorPane ancer_4;
    public Button buttonBuy_4;
    public ImageView image_4;
    public Label price_4;
    public Label location_4;
    public Label date_4;
    public TextArea text_4;
    //do next or back
    public Button button_back;
    public Button button_next;
    private boolean nextPage = true;
    int vacIndex = 1;
    //Deals
    public ImageView image_deal1;
    public ImageView image_deal2;
    public Label price_deal1;
    public Label price_deal2;
    public Label location_deal1;
    public Label location_deal2;
    public Label label_recommended;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc = MasterController.getInstance();
        this.vacation=Search.getVacations();
        text_1.setWrapText(true);
        text_2.setWrapText(true);
        text_3.setWrapText(true);
        text_4.setWrapText(true);
        for (int i = 0; i <vacation.size() ; i++) {
            if(!vacation.get(i).getVisible().equals("1")){
                vacation.remove(i);
            }
        }
        askforTrade = new Vacation();
        this.vacation_to_pick_for_trade=new ArrayList();
        initVec();

    }

    public void initializeFileds() {
        Field[] f = Class.class.getDeclaredFields();
    }

    private ArrayList<Vacation> listToVacation(ArrayList<List<String>> arrayList) {
        ArrayList<String> temp = new ArrayList<String>();
        ArrayList<Vacation> result = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).size(); j++) {
                temp.add(arrayList.get(i).get(j));
            }
            result.add(new Vacation(temp));
            temp.clear();
        }
        return result;
    }

    private void initVec() {

        if (vacation.size() > vacIndex-1) {
            price_1.setText(vacation.get(vacIndex-1).getPrice());
            location_1.setText(vacation.get(vacIndex-1).getLocation());
            date_1.setText(vacation.get(vacIndex-1).getStart_date() + " to " + vacation.get(vacIndex-1).getEnd_date());
            text_1.setText(vacation.get(vacIndex-1).getText());
            vacIndex++;
            //setNextIndexVec(vacIndex);
            ancer_1.setVisible(true);
            //image_1.setImage();
        }
        else{
            ancer_1.setVisible(false);
        }

        if (vacation.size() > vacIndex-1) {
            price_2.setText(vacation.get(vacIndex-1).getPrice());
            location_2.setText(vacation.get(vacIndex-1).getLocation());
            date_2.setText(vacation.get(vacIndex-1).getStart_date() + " to " + vacation.get(vacIndex-1).getEnd_date());
            text_2.setText(vacation.get(vacIndex-1).getText());
            //setNextIndexVec(vacIndex);
            vacIndex++;
            ancer_2.setVisible(true);
            //image_2.setImage();
        }
        else{
            ancer_2.setVisible(false);
        }



        if (vacation.size() > vacIndex-1) {
            price_3.setText(vacation.get(vacIndex-1).getPrice());
            location_3.setText(vacation.get(vacIndex-1).getLocation());
            date_3.setText(vacation.get(vacIndex-1).getStart_date() + " to " + vacation.get(vacIndex-1).getEnd_date());
            text_3.setText(vacation.get(vacIndex-1).getText());
            vacIndex++;
            //setNextIndexVec(vacIndex);
            ancer_3.setVisible(true);
            //image_3.setImage();
        }
        else{
            ancer_3.setVisible(false);
        }



        if (vacation.size() > vacIndex-1) {
            price_4.setText(vacation.get(vacIndex-1).getPrice());
            location_4.setText(vacation.get(vacIndex-1).getLocation());
            date_4.setText(vacation.get(vacIndex-1).getStart_date() + " to " + vacation.get(vacIndex-1).getEnd_date());
            text_4.setText(vacation.get(vacIndex-1).getText());
            vacIndex++;
            //setNextIndexVec(vacIndex);
            ancer_4.setVisible(true);
            //image_4.setImage();
        }
        else {
            ancer_4.setVisible(false);
        }

    }

    private void setNextIndexVec(int Index) {
        if (nextPage) {
            vacIndex++;
        }
        else {
            vacIndex--;
        }
    }

    public void backClick(javafx.event.ActionEvent event) {
        if(vacIndex!=4){
            vacIndex = vacIndex - vacIndex%4 -3 ;
            nextPage =false;
            initVec();
        }
    }

    public void nextClick(ActionEvent event){
        if(vacIndex<=vacation.size()){
            nextPage = true;
            initVec();
        }
        else
            event.consume();
    }

    public void buyVacation(ActionEvent event) throws IOException {
        //ask for permission
        String s = (((Button) event.getSource()).getId());
        char a = s.charAt(s.length()-1);
        Vacation v = vacation.get(Integer.parseInt(""+a)-1);
        if(v.getCreator().equals(mc.getUser().getUsername())){
            showInfoDialog("System Message","You can't buy your own vacations");

        }
        else if(mc.getDatabyFields(new Transaction(),"buyer",mc.getUser().getUsername(),"vacation_id",v.getVacation_id()).size() >0 ){
            showInfoDialog("System Message","You already requested this vacation");
        }
        else if(mc.getUser()!=null) {
            mc.insert(new Transaction(mc.getMax(new Transaction()) + 1, v.getCreator(), mc.getUser().getUsername(), v.getVacation_id(), "1"));
            showInfoDialog("Buying Message","Thank you for your order"+"\n"+"Message have been send to buyer for approve");
        }

        else{
            showInfoDialog("System Massage","You have to be connecting\nPlease SignUP or Register");
        }

    }

    public void tradeVacation(ActionEvent event) throws IOException {
        String s = (((Button) event.getSource()).getId());
        char a = s.charAt(s.length()-1);
        Vacation requested_vacation = vacation.get(Integer.parseInt(""+a)-1);
        askforTrade=requested_vacation;
        if(requested_vacation.getCreator().equals(mc.getUser().getUsername())){
            showInfoDialog("System Message","You can't trade your own vacations");
        }
        else if(mc.getDatabyFields(new Vacation(),"creator",mc.getUser().getUsername()).size()<=0){
            showInfoDialog("System Message","You don't have vacations to trade");
        }
        else if(mc.getDatabyFields(new Transaction(),"vacation_id",requested_vacation.getVacation_id(),"buyer",mc.getUser().getUsername()).size() >0){
            showInfoDialog("System Message","You already requested this vacation");
        }
        else if(mc.getDatabyFields(new Vacation(),"creator",mc.getUser().getUsername()).size()>0) {
            ArrayList<List<String>> result = mc.getDatabyFields(new Vacation(),"creator",mc.getUser().getUsername());
            if (result.size() > 0) {
                vacation_to_pick_for_trade = listToVacation(result);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("ChooseVacationForTrade.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                Scene scene = new Scene(root, 1200, 509);
                scene.getStylesheets().add(getClass().getClassLoader().getResource("showVac.css").toExternalForm());
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setOpacity(1);
                stage.setTitle("Choose Vacation For Trade");
                stage.setScene(scene);
                stage.showAndWait();


            }
        }
//        else if(mc.getUser()!=null) {
//            mc.insert(new Transaction(mc.getMax(new Transaction()) + 1, v.getCreator(), mc.getUser().getUsername(), v.getVacation_id(), "1"));
//            showInfoDialog("Buying Message","Thank you for your order"+"\n"+"Message have been send to buyer for approve");
//        }

        else{
            showInfoDialog("System Massage","You have to be connecting\nPlease SignUP or Register");
        }



    }

    public void showInfoDialog(String Heading,String Body) {
        StackPane pane = new StackPane();
        pane.setPrefWidth(ancer_show.getPrefWidth()/2);
        pane.setPrefHeight(ancer_show.getPrefHeight()/2);
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text(Heading));
        content.setBody(new Text(Body));
        JFXDialog dialog = new JFXDialog(pane, content, JFXDialog.DialogTransition.CENTER);
        JFXButton button = new JFXButton("Okay");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
                ancer_show.getScene().getWindow().hide();
            }
        });
        content.setActions(button);
        ancer_show.getChildren().add(pane);
        dialog.show();
    }

    public static ArrayList<Vacation> getVacation_to_pick_for_trade() {
        return vacation_to_pick_for_trade;
    }

    public static void setVacation_to_pick_for_trade(ArrayList<Vacation> vacation_to_pick_for_trade) {
        ShowVacation.vacation_to_pick_for_trade = vacation_to_pick_for_trade;
    }

    public static Vacation getAskforTrade() {
        return askforTrade;
    }

    public static void setAskforTrade(Vacation askforTrade) {
        ShowVacation.askforTrade = askforTrade;
    }
}
