package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainWin.fxml"));
        primaryStage.setTitle("V4U");
        Scene scene = new Scene(root, 800  , 600);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("mainWin.css").toExternalForm());
        primaryStage.setScene(scene);
//        controller.setStage(primaryStage);
//        Database d = new Database();
//        d.createNewDatabase("vacation4u");
//        d.connect();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
