package com.example.javafxhelloworld;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CoffeeShopController {

    private ArrayList<Order> orders;

    @FXML
    private RadioButton espressoRadioButton;
    @FXML
    private CheckBox milkCheckBox;
    @FXML
    private ToggleGroup beverage;
    @FXML
    private RadioButton americanRadioButton;
    @FXML
    private RadioButton coffeeRadioButton;
    @FXML
    private CheckBox creamCheckBox;
    @FXML
    private CheckBox sugarCheckBox;
    @FXML
    private CheckBox soyMilkCheckBox;

    @FXML
    private Button orderButton;
    @FXML
    private Label currentDrink;
    @FXML
    private TextArea receiptTextArea;

    private Order currentOrder;
    @FXML
    private Label grandTotalLabel;

    private String name;
    @FXML
    private Button saveButton;


    public CoffeeShopController() {
        orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
        printReceipt();
    }

    public void setName(String name) {
        this.name = name;
    }

    @FXML
    public void drinkButtonClicked(ActionEvent actionEvent) {
        BeverageType beverageType = BeverageType.coffee;
        if ( coffeeRadioButton.isSelected() ) {
            beverageType = BeverageType.coffee;
        } else if (  espressoRadioButton.isSelected() ) {
            beverageType = BeverageType.espresso;
        }
        else if ( americanRadioButton.isSelected()){
            beverageType = BeverageType.americano;
        }
        currentOrder = new Order(beverageType);
        currentOrder.setHasSugar(sugarCheckBox.isSelected());
        currentOrder.setHasCream(creamCheckBox.isSelected());
        currentOrder.setHasMilk(milkCheckBox.isSelected());
        currentOrder.setHasSoyMilk(soyMilkCheckBox.isSelected());

        currentDrink.setText(currentOrder.toString());

    }

    @FXML
    public void orderButtonClicked(ActionEvent actionEvent) {
        orders.add(currentOrder);
        printReceipt();
    }

    private void printReceipt() {
        receiptTextArea.setText("");
        double grandTotal = 0;
        for ( Order order : orders ) {
            receiptTextArea.appendText(order.toString() + "\n");
            grandTotal += order.getPrice();
        }
        grandTotalLabel.setText(name + "'s Grand Total $" + grandTotal);
    }

    @FXML
    public void saveButtonClicked(ActionEvent actionEvent) {
        // https://github.com/EricCharnesky/CIS296-Fall2025/blob/main/Week4-FileIO/src/Main.java
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name + ".ser"))) {
            oos.writeObject(orders);
            System.out.println("Object has been serialized.");
        } catch (IOException e) {
            // bing ai "javafx pop up alert for errors"
            // Create an alert of type INFORMATION
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Unable to save");
            alert.setContentText(e.toString());

            // Show the alert
            alert.showAndWait();
        }
    }
}