package view;

import Contrroller.MasterController;
import Entities.Transaction;
import Entities.Vacation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserApprove implements Initializable{


    //list vacation
    private ArrayList<Transaction> transactions;
    private ArrayList<Vacation> vacation;
    private ArrayList<Vacation> fourVac;
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
        transactions = new ArrayList<>();
        vacation = new ArrayList<>();
        fourVac = new ArrayList<>();
        mc = MasterController.getInstance();
        loadVacation();
        //this.vacation=Search.getVacations();
        text_1.setWrapText(true);
        text_2.setWrapText(true);
        text_3.setWrapText(true);
        text_4.setWrapText(true);
        initVec();
    }

    private void loadVacation() {
        for (Transaction t: transactions) {
            listToVacation(mc.read(new Vacation(),"vacation_id",t.getTransaction_id()));
        }
    }


    private void listToVacation(ArrayList<List<String>> arrayList) {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).size(); j++) {
                temp.add(arrayList.get(i).get(j));
            }
            vacation.add(new Vacation(temp));
            temp.clear();
        }
    }


    private void initVec() {
        fourVac.clear();
        if (vacation.size() > vacIndex-1) {
            price_1.setText(vacation.get(vacIndex-1).getPrice());
            location_1.setText(vacation.get(vacIndex-1).getLocation());
            date_1.setText(vacation.get(vacIndex-1).getStart_date() + " to " + vacation.get(vacIndex-1).getEnd_date());
            text_1.setText(vacation.get(vacIndex-1).getText());
            fourVac.add(0,vacation.get(vacIndex-1));
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
            fourVac.add(1,vacation.get(vacIndex-1));
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
            fourVac.add(2,vacation.get(vacIndex-1));
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
            fourVac.add(3,vacation.get(vacIndex-1));
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

    public void backClick(ActionEvent event) {
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

    public void clickButton(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ancer_show.getScene().getWindow();
        String s = (((Button) event.getSource()).getId());
        char a = s.charAt(s.length()-1);
        Vacation v = fourVac.get(Integer.parseInt(""+a)-1);
        Transaction t = transactions.get(Integer.parseInt(""+a)-1);
        mc.update(new Transaction(Integer.parseInt(t.getTransaction_id()),t.getSeller(),t.getBuyer(),t.getVacation_id(),"2"));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Approval Message");
        alert.setHeaderText("Approval Massage");
        alert.setContentText("Thank you for your Approval\nThe request has been sent. Please wait for approval of payment");
        alert.show();
    }

}
