package com.example.javafxhelloworld;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class HelloController {

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


    public HelloController() {
        orders = new ArrayList<>();
    }

    public String getName() {
        return name;
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
        receiptTextArea.appendText(currentOrder.toString() + "\n");
        double grandTotal = 0;
        for ( Order order : orders ) {
            grandTotal += order.getPrice();
        }
        grandTotalLabel.setText(name + "'s Grand Total $" + grandTotal);
    }
}