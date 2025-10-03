package com.example.javafxhelloworld;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class WelcomeController {

    @javafx.fxml.FXML
    private Button launchButton;
    @javafx.fxml.FXML
    private TextField nameTextField;


    @javafx.fxml.FXML
    public void launchButtonClicked(ActionEvent actionEvent) {
        try {
            HelloApplication.switchScene("coffee-shop-view.fxml", nameTextField.getText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
