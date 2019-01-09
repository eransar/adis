package view;

import Contrroller.MasterController;
import Entities.Transaction;
import Entities.Vacation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ChooseVacationForTrade implements Initializable {
    //list vacation
    private ArrayList<Vacation> vacation;
    private Vacation requested_vacation;
    //mc - singleton
    private MasterController mc;
    public AnchorPane ancer_show;
    private int currentid;
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
        this.vacation = ShowVacation.getVacation_to_pick_for_trade();
        this.requested_vacation = ShowVacation.getAskforTrade();
        text_1.setWrapText(true);
        text_2.setWrapText(true);
        text_3.setWrapText(true);
        text_4.setWrapText(true);
        ArrayList<Vacation> temp = new ArrayList();
        for (Vacation v: vacation){
            if(!v.getVisible().equals("1")){
                temp.add(v);
            }
        }
        vacation.removeAll(temp);
        initVec();

    }

    public void initializeFileds() {
        Field[] f = Class.class.getDeclaredFields();
    }

    private void initVec() {

        if (vacation.size() > vacIndex - 1) {
            price_1.setText(vacation.get(vacIndex - 1).getPrice());
            location_1.setText(vacation.get(vacIndex - 1).getLocation());
            date_1.setText(vacation.get(vacIndex - 1).getStart_date() + " to " + vacation.get(vacIndex - 1).getEnd_date());
            text_1.setText(vacation.get(vacIndex - 1).getText());
            vacIndex++;
            //setNextIndexVec(vacIndex);
            ancer_1.setVisible(true);
            //image_1.setImage();
        } else {
            ancer_1.setVisible(false);
        }

        if (vacation.size() > vacIndex - 1) {
            price_2.setText(vacation.get(vacIndex - 1).getPrice());
            location_2.setText(vacation.get(vacIndex - 1).getLocation());
            date_2.setText(vacation.get(vacIndex - 1).getStart_date() + " to " + vacation.get(vacIndex - 1).getEnd_date());
            text_2.setText(vacation.get(vacIndex - 1).getText());
            //setNextIndexVec(vacIndex);
            vacIndex++;
            ancer_2.setVisible(true);
            //image_2.setImage();
        } else {
            ancer_2.setVisible(false);
        }


        if (vacation.size() > vacIndex - 1) {
            price_3.setText(vacation.get(vacIndex - 1).getPrice());
            location_3.setText(vacation.get(vacIndex - 1).getLocation());
            date_3.setText(vacation.get(vacIndex - 1).getStart_date() + " to " + vacation.get(vacIndex - 1).getEnd_date());
            text_3.setText(vacation.get(vacIndex - 1).getText());
            vacIndex++;
            //setNextIndexVec(vacIndex);
            ancer_3.setVisible(true);
            //image_3.setImage();
        } else {
            ancer_3.setVisible(false);
        }


        if (vacation.size() > vacIndex - 1) {
            price_4.setText(vacation.get(vacIndex - 1).getPrice());
            location_4.setText(vacation.get(vacIndex - 1).getLocation());
            date_4.setText(vacation.get(vacIndex - 1).getStart_date() + " to " + vacation.get(vacIndex - 1).getEnd_date());
            text_4.setText(vacation.get(vacIndex - 1).getText());
            vacIndex++;
            //setNextIndexVec(vacIndex);
            ancer_4.setVisible(true);
            //image_4.setImage();
        } else {
            ancer_4.setVisible(false);
        }

    }

    private void setNextIndexVec(int Index) {
        if (nextPage) {
            vacIndex++;
        } else {
            vacIndex--;
        }
    }

    public void backClick(javafx.event.ActionEvent event) {
        if (vacIndex != 4) {
            vacIndex = vacIndex - vacIndex % 4 - 3;
            nextPage = false;
            initVec();
        }
    }

    public void nextClick(ActionEvent event) {
        if (vacIndex <= vacation.size()) {
            nextPage = true;
            initVec();
        } else
            event.consume();
    }

    public void pickVacation(ActionEvent event) throws IOException {
        String s = (((Button) event.getSource()).getId());
        char a = s.charAt(s.length() - 1);
        Vacation picked_vacation = vacation.get(Integer.parseInt("" + a) - 1);
        currentid = Integer.parseInt("" + a) - 1;
        // if the requested vacation somehow already transactioned
        if (mc.getDatabyFields(new Transaction(), "buyer", mc.getUser().getUsername(), "vacation2_id", picked_vacation.getVacation_id()).size() > 0) {
            showTradeDialog("System Message", "You already requested to exchange this vacaiton before. Please choose what to do");
        } else if (mc.getUser() != null) {
            mc.insert(new Transaction(mc.getMax(new Transaction()) + 1, requested_vacation.getCreator(), mc.getUser().getUsername(), requested_vacation.getVacation_id(), "1", picked_vacation.getVacation_id(), "exchange"));
            showInfoDialog("Exchanging Vacation Message", "Thank you for your request" + "\n" + "Message have been send to the user for approve");
        } else {
            showInfoDialog("System Massage", "You have to be connecting\nPlease SignUP or Register");
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

    public void showTradeDialog(String headingText, String bodyText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog with Custom Actions");
        alert.setHeaderText(headingText);
        alert.setContentText(bodyText);

        ButtonType buttonTypeOne = new ButtonType("Don't do anything",ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType cancelrequest = new ButtonType("Cancel the request");
//        ButtonType buttonTypeThree = new ButtonType("Three");
//        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, cancelrequest);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            // ... user chose "One"
        } else if (result.get() == cancelrequest) {

            ArrayList<Transaction> transaction = listToTransaction(mc.getDatabyFields(new Transaction(), "vacation2_id", vacation.get(currentid).getVacation_id()));
            mc.delete(transaction.get(0));
            alert.close();
//            dialog.close();
            // ... user chose "Two"
//        } else if (result.get() == buttonTypeThree) {
            // ... user chose "Three"
        } else {
            // ... user ch
        }
    }


        private ArrayList<Transaction> listToTransaction (ArrayList < List < String >> arrayList) {
            ArrayList<String> temp = new ArrayList<String>();
            ArrayList<Transaction> result = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                for (int j = 0; j < arrayList.get(i).size(); j++) {
                    temp.add(arrayList.get(i).get(j));
                }
                result.add(new Transaction(temp));
                temp.clear();
            }
            return result;
        }

    }




