package com.example.javafxhelloworld;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class HelloController {

    @FXML
    private Button button;
    @FXML
    private Label textField;

    Counter counter;
    @FXML
    private Button otherButton;

    public HelloController() {
        counter =  new Counter();
    }

    @FXML
    public void buttonClicked(ActionEvent actionEvent) {
        counter.increment();
        setLabelText();
    }

    @FXML
    public void otherButtonClick(ActionEvent actionEvent) {
        counter.decrement();
        setLabelText();
    }

    private void setLabelText(){
        textField.setText("Clicked " + counter.getCount() + " times.");
    }
}