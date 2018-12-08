package Contrroller.Handlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class CloseStageHandler implements EventHandler {




    @Override
    public void handle(Event event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
