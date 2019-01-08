package view;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ApprovePayment implements Initializable{

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
        //this.vacation=Search.getVacations();
        text_1.setWrapText(true);
        text_2.setWrapText(true);
        text_3.setWrapText(true);
        text_4.setWrapText(true);
        SellerOrBuyer();
        loadVacation();
        initVec();
    }


    private void SellerOrBuyer() {
        
        ArrayList<List<String>> list = mc.getDatabyFields(new Transaction(), "seller", mc.getUser().getUsername(), "statuscode", "2");
        listToTransaction(list);
    }


    private void listToTransaction(ArrayList<List<String>> arrayList) {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).size(); j++) {
                temp.add(arrayList.get(i).get(j));
            }
            transactions.add(new Transaction(temp));
            temp.clear();
        }
    }

    private void loadVacation() {
        for (Transaction t: transactions) {
            listToVacation(mc.read(new Vacation(),"vacation_id",t.getVacation_id()));
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
        char a = s.charAt(s.length() - 1);
        Vacation v = fourVac.get(Integer.parseInt("" + a) - 1);
        Transaction t = transactions.get(Integer.parseInt("" + a) - 1);
        String message ="By clicking OK You agree for getting a payment of "+v.getPrice()+" from "+t.getBuyer();
        showapprovalInfo("Approve you got the payment",message,t,v);

    }
    public void showapprovalInfo(String headingText, String bodyText, Transaction t,Vacation v) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog with  Actions");
        alert.setHeaderText(headingText);
        alert.setContentText(bodyText);

        ButtonType buttonTypeOne = new ButtonType("Cancel",ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType ok = new ButtonType("OK");
//        ButtonType buttonTypeThree = new ButtonType("Three");
//        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, ok);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            // ... user chose "One"
        } else if (result.get() == ok) {
            t.setStatuscode("3"); //closing transaction
            mc.update(t); //updating database
//            v.setVisible("0");//making vacation not visible
//            mc.update(v); //updating vacation in database
            alert.close();

        }


}
}
//        Payments.currentVacation=v;
//        Payments.setCurrenttransaction(t);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Payment.fxml"));
//        Parent root = fxmlLoader.load();
//        Stage stage = new Stage();
//        Scene scene = new Scene(root, 600  , 460);
//        scene.getStylesheets().add(getClass().getClassLoader().getResource("Activities.css").toExternalForm());
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.setOpacity(1);
//        stage.setTitle("Vacation4u Payments");
//        stage.setScene(scene);
//        stage.showAndWait();
//        ((Node)(event.getSource())).getScene().getWindow().hide();



