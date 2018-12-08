package view;

import Contrroller.MasterController;
import Entities.User;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Search implements Initializable, IView {
    public JFXComboBox<String> search_options;
    public TextField field_search;
    public AnchorPane tablepane;
    public Label noResult;
    public AnchorPane pane;
    public Button button_Search;
    private MasterController mc;
    private User search_user;
    private  ArrayList<List<String>> result;
    private static ArrayList<User> Users;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set ChoiceSearch
        button_Search.setId("button_Search");
        mc = MasterController.getInstance();
        result = new ArrayList<List<String>>();
        Users = new ArrayList<User>();
        search_options.setValue("user");
        search_options.getItems().addAll("user","vacation");
         noResult.setVisible(false);
    }
    public static void setUsers(){
        Users.clear();
    }


    private void centerStage(Stage stage, double width, double height) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - width) / 2);
        stage.setY((screenBounds.getHeight() - height) / 2);
    }

    public void Search_click(ActionEvent actionEvent) throws IOException {
        //setSearchScene();
        if (!(field_search.getText().equals(""))) {
            mc.setPrefHeightSearch(tablepane.getPrefHeight());
            mc.setPrefWidthSerach(tablepane.getPrefWidth());
            if (search_options.getValue().equals("user")) {
                /////master controller?
                search_user = new User(field_search.getText());
                result = mc.read(search_user, "username", field_search.getText());
                Users = listToUser(result);
                ////
                if (result.size() > 0) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("UserTableView.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    Scene scene = new Scene(root, 410, 460);
                    scene.getStylesheets().add(getClass().getClassLoader().getResource("Signup.css").toExternalForm());
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setOpacity(1);
                    stage.setTitle("User Search");
                    stage.setScene(scene);
                    stage.showAndWait();
//                    AnchorPane pane11 = FXMLLoader.load(getClass().getResource("/UserTableView.fxml"));
//                    tablepane.getChildren().setAll(pane11);
//                    noResult.setVisible(false);
                } else
                    noResult.setVisible(true);
            } else if (search_options.getValue().equals("vacation")) {
                //if(result.size()>0){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("ShowVacationFxml.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                Scene scene = new Scene(root, 1200, 720);
                scene.getStylesheets().add(getClass().getClassLoader().getResource("showVac.css").toExternalForm());
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setOpacity(1);
                stage.setTitle("Vacation search");
                stage.setScene(scene);
                stage.showAndWait();
                //AnchorPane pane11 = FXMLLoader.load(getClass().getResource("/ShowVacationFxml.fxml"));
                //tablepane.getChildren().setAll(pane11);
            }
        //}
            //else {
             //   noResult.setVisible(true);
           // }
                noResult.setVisible(false);
        }
    }

    private void setSearchScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainWin.fxml"));
        Stage primaryStage = mc.getStage();
        primaryStage.setTitle("Vacation4U");
        Scene scene = new Scene(root, 1600  , 800);
        centerStage(primaryStage,1600,800);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("mainWin.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private ArrayList<User> listToUser(ArrayList<List<String>> arrayList){

        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i <arrayList.size() ; i++) {
            for (int j = 0; j <arrayList.get(i).size() ; j++) {
                temp.add(arrayList.get(i).get(j));
            }
            Users.add(new User(temp));
            temp.clear();
        }

        return Users;
    }

    public static ArrayList<User> getUsers() {
        return Users;
    }

    @Override
    public void setCurrentView() {
        mc.setIview(this);
    }
}
