/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import core.Calculator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import operations.Addition;
import operations.Division;
import operations.Multiplication;
import operations.Subtraction;
import utils.MathResultFormatter;

/**
 *
 * @author animusanima
 */
public class MainViewController implements Initializable {

    @FXML
    private TextField first_number;

    @FXML
    private TextField second_number;

    @FXML
    private TextArea output_area;

    private final Calculator calc = new Calculator();

    private int number_one, number_two;

    private Addition add;
    private Subtraction subtract;
    private Multiplication multiply;
    private Division divide;

    private String results;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        add = new Addition();
        subtract = new Subtraction();
        multiply = new Multiplication();
        divide = new Division();

        first_number.setText("0");
        first_number.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.isEmpty() && newValue.matches("[0-9]+")) {
                number_one = Integer.valueOf(newValue);
            } else {
                number_one = 0;
            }
            calculateResultsAndPrint(number_one, number_two);
        });

        second_number.setText("0");
        second_number.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.isEmpty() && newValue.matches("[0-9]+")) {
                number_two = Integer.valueOf(newValue);
            } else {
                number_one = 0;
            }
            calculateResultsAndPrint(number_one, number_two);
        });              
    }

    private void calculateResultsAndPrint(int number_one, int number_two) {
        output_area.clear();

        int addition = calc.compute(number_one, number_two, add);
        int subtraction = calc.compute(number_one, number_two, subtract);
        int multiplication = calc.compute(number_one, number_two, multiply);
        int division = calc.compute(number_one, number_two, divide);

        results  = MathResultFormatter.printAddition(number_one, number_two, addition);
        results += MathResultFormatter.printSubtraction(number_one, number_two, subtraction);
        results += MathResultFormatter.printMultiplication(number_one, number_two, multiplication);
        results += MathResultFormatter.printDivision(number_one, number_two, division);

        output_area.setText(results);
    }

}
