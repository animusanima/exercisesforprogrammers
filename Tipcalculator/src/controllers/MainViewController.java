/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tipcalculator.TipCalculator;
import utils.CalculatorUtils;
import utils.ConversionUtils;
import validator.DoubleValidator;

/**
 *
 * @author animusanima
 */
public class MainViewController implements Initializable 
{
    
    @FXML
    private TextField billAmountField;
    
    @FXML
    private TextField tipRateField;
    
    @FXML
    private TextField tipField;
    
    @FXML
    private TextField totalField;
    
    @FXML
    private Label billAmountInvalid;
    
    @FXML
    private Label tipRateInvalid;
    
    private ChangeListener<String> amountFieldListener;
    private ChangeListener<String> tipRateFieldListener;
    
    private final TipCalculator calculator = new TipCalculator(0.0, 0.0);
            
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {        
        createAndRegisterListenerForBillAmount();        
        createAndRegisterTipRateListener(); 
    }  

    private void createAndRegisterTipRateListener() {
        tipRateFieldListener = (observable, oldValue, newValue) ->
        {   
        if ( (newValue != null) && (!newValue.isEmpty()) )
            {
                try {
                    updateTipRate(newValue);                                        
                    updateTipAndTotal();
                } catch (NumberFormatException numEx) {
                    showTipRateErrorField(numEx);
                } catch (IllegalArgumentException illegalEx) {
                    showTipRateErrorField(illegalEx);
                }
            }            
        };        
        tipRateField.textProperty().addListener(tipRateFieldListener);
    }      

    private void showTipRateErrorField(Exception ex) {
        tipRateInvalid.setText(ex.getMessage());
        tipRateInvalid.setVisible(true);
    }

    private void hideTipRateErrorField() {
        tipRateInvalid.setVisible(false);
        tipRateInvalid.setText("");
    }

    private void updateTipRate(String newValue) throws NumberFormatException {
        double newTipRate = ConversionUtils.safeConvertToDouble(newValue);
        calculator.updateTipRate(newTipRate);
        hideTipRateErrorField();
    }

    private void createAndRegisterListenerForBillAmount() {
        amountFieldListener = (observable, oldValue, newValue) ->
        {
            if ( (newValue != null) && (!newValue.isEmpty()) )
            {
                try {                
                    double newBillAmount = ConversionUtils.safeConvertToDouble(newValue);
                    if (DoubleValidator.validate(newBillAmount))
                        updateBillAmount(newValue);
                    updateTipAndTotal();
                } catch (NumberFormatException numEx) {
                    showBillAmountErrorField(numEx);
                } catch (IllegalArgumentException illegalEx) {
                    showBillAmountErrorField(illegalEx);
                }
            }
        };        
        billAmountField.textProperty().addListener(amountFieldListener);
    }        

    private void showBillAmountErrorField(Exception ex) 
    {
        billAmountInvalid.setText(ex.getMessage());
        billAmountInvalid.setVisible(true);
    }

    private void updateBillAmount(String newValue) throws NumberFormatException 
    {
        calculator.updateBillAmount(ConversionUtils.safeConvertToDouble(newValue));
        hideBillAmountErrorField();
    }

    private void hideBillAmountErrorField()
    {
        billAmountInvalid.setVisible(false);
        billAmountInvalid.setText("");
    }
    
    private void updateTipAndTotal()
    {
        totalField.setText(String.valueOf(calculator.calculateTotal()));
        tipField.setText(String.valueOf(calculator.calculateTip()));
    }
}