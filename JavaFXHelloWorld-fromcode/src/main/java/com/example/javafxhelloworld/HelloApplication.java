package com.example.javafxhelloworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    // Murach Java example from chapter 12

    private TextField investmentField;
    private TextField interestRateField;
    private TextField yearsField;
    private TextField futureValueField;

    @Override
    public void start(Stage stage) throws IOException {

        // set stage title
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Future Value Calculator");
        // create grid, create scene, and add grid to scene
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 400, 300);

        grid.add(new Label("Monthly Investment:"), 0, 0); // col 1, row 1
        grid.add(new Label("Yearly Interest Rate:"), 0, 1); // col 1, row 2
        grid.add(new Label("Years:"), 0, 2);
        grid.add(new Label("Future Value:"), 0, 3);


        investmentField = new TextField();
        grid.add(investmentField, 1, 0);

        interestRateField = new TextField();
        grid.add(interestRateField, 1, 1);

        yearsField = new TextField();
        grid.add(yearsField, 1, 2);

        futureValueField = new TextField();
        futureValueField.setEditable(false);
        grid.add(futureValueField, 1, 3);

        Button calculateButton = new Button("Calculate");
        Button exitButton = new Button("Exit");

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(calculateButton);
        buttonBox.getChildren().add(exitButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);

        // add the box to row 5, spanning 2 columns and 1 row
        grid.add(buttonBox, 0, 4, 2, 1);

        calculateButton.setOnAction(event -> calculateButtonClicked());


        // set scene and display stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateButtonClicked() {
        double total = 0;
        // get data from text fields
        double monthlyInvestment = Double.parseDouble(investmentField.getText());
        double rate = Double.parseDouble(interestRateField.getText());
        int years = Integer.parseInt(yearsField.getText());
// calculate future value

        for ( int year = 0; year < years; year++ ){
            total += total * rate + monthlyInvestment*12;
        }

        double futureValue = total;
// set data in read-only text field
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        futureValueField.setText(currency.format(futureValue));

    }

    public static void main(String[] args) {
        launch();
    }
}