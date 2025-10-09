package com.example.javafxhelloworld;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class WelcomeController {

    @javafx.fxml.FXML
    private Button launchButton;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private AnchorPane ap;
    @javafx.fxml.FXML
    private Button loadOrderButton;


    @javafx.fxml.FXML
    public void launchButtonClicked(ActionEvent actionEvent) {
        try {
            HelloApplication.switchScene("coffee-shop-view.fxml", nameTextField.getText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void loadOrderButtonClicked(ActionEvent actionEvent) {

        //https://github.com/EricCharnesky/CIS296-Fall2025/blob/main/Week4-FileIO/src/Main.java#L108C8-L114C10
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameTextField.getText() + ".ser"))) {
            ArrayList<Order> orders = (ArrayList<Order>) ois.readObject();
            System.out.println("Object has been deserialized.");
            HelloApplication.switchScene("coffee-shop-view.fxml", nameTextField.getText(), orders);

        } catch (IOException | ClassNotFoundException e) {
            // bing ai "javafx pop up alert for errors"
            // Create an alert of type INFORMATION
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Unable to load");
            alert.setContentText(e.toString());

            // Show the alert
            alert.showAndWait();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
