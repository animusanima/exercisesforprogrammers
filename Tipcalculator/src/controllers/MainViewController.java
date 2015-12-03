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
import utils.CalculatorUtils;

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
    
    private String billAmount;
    private String tipRate;
    
    private ChangeListener<String> amountFieldListener;
    private ChangeListener<String> tipRateFieldListener;
            
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
                    tipRate = String.valueOf(CalculatorUtils.convertTipRateToNumber(newValue));                    
                    tipRateInvalid.setVisible(false);
                    tipRateInvalid.setText("");
                    updateTipAndTotal();
                } catch (NumberFormatException numEx) {
                    tipRateInvalid.setText(numEx.getMessage());
                    tipRateInvalid.setVisible(true);
                } catch (IllegalArgumentException illegalEx) {
                    tipRateInvalid.setText(illegalEx.getMessage());
                    tipRateInvalid.setVisible(true);
                }
            }            
        };        
        tipRateField.textProperty().addListener(tipRateFieldListener);
    }      

    private void createAndRegisterListenerForBillAmount() {
        amountFieldListener = (observable, oldValue, newValue) ->
        {
            if ( (newValue != null) && (!newValue.isEmpty()) )
            {
                try {
                    billAmount = String.valueOf(CalculatorUtils.convertBillAmountToNumber(newValue));
                    billAmountInvalid.setVisible(false);
                    billAmountInvalid.setText("");
                    updateTipAndTotal();                    
                } catch (NumberFormatException numEx) {
                    billAmountInvalid.setText(numEx.getMessage());
                    billAmountInvalid.setVisible(true);
                } catch (IllegalArgumentException illegalEx) {
                    billAmountInvalid.setText(illegalEx.getMessage());
                    billAmountInvalid.setVisible(true);
                }
            }
        };        
        billAmountField.textProperty().addListener(amountFieldListener);
    }

    private void updateTipAndTotal() throws NumberFormatException {
        if (billAmount != null && tipRate != null)
        {
            tipField.textProperty().setValue(String.valueOf(CalculatorUtils.determineTip(billAmount, tipRate)));
            totalField.textProperty().setValue(String.valueOf(
                    CalculatorUtils.calculateTotal(billAmount, String.valueOf(CalculatorUtils.determineTip(billAmount, tipRate)))));
        }
    }        
    
}