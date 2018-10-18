package Controller;

import javafx.event.Event;
import model.Model;
import view.View;

import java.util.Observable;
import java.util.Observer;

public class Controller extends Observable implements Observer {


    private Model model;
    private View view;
    public Controller(Model model , View view){
        this.model = model;
        this.view = view;
    }

    public void CreateANewUser(){

    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
