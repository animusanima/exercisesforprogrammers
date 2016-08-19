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
import models.MathModel;
import operations.Addition;
import operations.Division;
import operations.Multiplication;
import operations.Subtraction;
import utils.MathResultFormatter;
import utils.NumberVerifier;

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
    private final MathModel model = new MathModel(0, 0);

    private String results;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        first_number.setText("0");
        first_number.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.isEmpty() && NumberVerifier.hasNumbersOnly(newValue)) {
                model.updateVariables(Integer.valueOf(newValue), model.getVariableB());
            } else {
                model.updateVariables(0, model.getVariableB());
            }
            calculateResultsAndPrint();
        });

        second_number.setText("0");
        second_number.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.isEmpty() && NumberVerifier.hasNumbersOnly(newValue)) {
                model.updateVariables(model.getVariableA(), Integer.valueOf(newValue));
            } else {
                model.updateVariables(model.getVariableA(), 0);
            }
            calculateResultsAndPrint();
        });
    }

    private void calculateResultsAndPrint() {
        output_area.clear();

        int addition = calc.add(model.getVariableA(), model.getVariableB());
        int subtraction = calc.subtract(model.getVariableA(), model.getVariableB());
        int multiplication = calc.multiply(model.getVariableA(), model.getVariableB());
        int division = calc.divide(model.getVariableA(), model.getVariableB());

        results = MathResultFormatter.printAddition(model.getVariableA(), model.getVariableB(), addition);
        results += MathResultFormatter.printSubtraction(model.getVariableA(), model.getVariableB(), subtraction);
        results += MathResultFormatter.printMultiplication(model.getVariableA(), model.getVariableB(), multiplication);
        results += MathResultFormatter.printDivision(model.getVariableA(), model.getVariableB(), division);

        output_area.setText(results);
    }

}