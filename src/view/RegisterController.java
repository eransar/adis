package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Model;

import java.io.IOException;

public class RegisterController {
@FXML
    Button sign_up;
    Model model;

    public void init(Model model){
        this.model=model;
    }

    public void RegisterClick(ActionEvent actionEvent) throws IOException {

    }

}

