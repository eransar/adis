package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Database;
import view.View;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("V4U");
        FXMLLoader fxmlLoader = new FXMLLoader();
        Scene scene = new Scene(root, 600  , 400);
        scene.getStylesheets().add(getClass().getResource("viewCSS.css").toExternalForm());
        primaryStage.setScene(scene);
        Database d = new Database();
        d.createNewDatabase("vacation4u");
        d.connect();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
