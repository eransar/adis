package view;
import Controller.Controller;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class View extends java.util.Observable {

    @FXML
    private Parent root;
    private Stage stage;
    private Scene scene;
    public GridPane window;


    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void RegisterClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("Register.fxml").openStream());
        Scene scene = new Scene(root,400,300);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
        scene.getStylesheets().add(getClass().getResource("MyCSS.css").toExternalForm());
        stage.show();
    }



}