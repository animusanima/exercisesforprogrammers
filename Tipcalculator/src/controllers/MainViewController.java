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
                    double newTipRate = ConversionUtils.safeConvertToDouble(newValue);
                    if (DoubleValidator.validate(newTipRate))
                    {
                        updateTipRate(newValue);                                        
                        hideTipRateErrorField();
                        updateTipAndTotal();
                    }                    
                } catch (NumberFormatException numEx) {
                    showTipRateErrorForExceptionType(numEx);
                } catch (IllegalArgumentException illegalEx) {
                    showTipRateErrorForExceptionType(illegalEx);
                }
            }            
        };        
        tipRateField.textProperty().addListener(tipRateFieldListener);
    }      

    private void showTipRateErrorForExceptionType(Exception ex) {
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
    }

    private void createAndRegisterListenerForBillAmount() {
        amountFieldListener = (observable, oldValue, newValue) ->
        {
            if ( (newValue != null) && (!newValue.isEmpty()) )
            {
                try {                
                    double newBillAmount = ConversionUtils.safeConvertToDouble(newValue);
                    if (DoubleValidator.validate(newBillAmount))
                    {                        
                        updateBillAmount(newValue);
                        hideBillAmountErrorField();
                        updateTipAndTotal();
                    }
                } catch (NumberFormatException numEx) {
                    showBillAmountErrorForExceptionType(numEx);
                } catch (IllegalArgumentException illegalEx) {
                    showBillAmountErrorForExceptionType(illegalEx);
                }
            }
        };        
        billAmountField.textProperty().addListener(amountFieldListener);
    }        

    private void showBillAmountErrorForExceptionType(Exception ex) 
    {
        billAmountInvalid.setText(ex.getMessage());
        billAmountInvalid.setVisible(true);
    }

    private void updateBillAmount(String newValue) throws NumberFormatException 
    {
        calculator.updateBillAmount(ConversionUtils.safeConvertToDouble(newValue));        
    }

    private void hideBillAmountErrorField()
    {
        billAmountInvalid.setVisible(false);
        billAmountInvalid.setText("");
    }
    
    private void updateTipAndTotal()
    {        
        double roundedTotal = CalculatorUtils.roundToNearestCent(calculator.calculateTotal());        
        totalField.setText(String.valueOf(roundedTotal));
        double roundedTip = CalculatorUtils.roundToNearestCent(calculator.calculateTip());
        tipField.setText(String.valueOf(roundedTip));
    }
}