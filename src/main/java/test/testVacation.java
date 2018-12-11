package test;

import Contrroller.MasterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javafx.application.Application.launch;

public class testVacation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("testfx.fxml"));
        primaryStage.setTitle("Vacation4U");
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        MasterController.getInstance().setStage(primaryStage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    public void testVacation() {
        ArrayList<List<String>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());


    }
}