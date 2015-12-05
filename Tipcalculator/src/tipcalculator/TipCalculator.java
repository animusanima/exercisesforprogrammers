/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import utils.CalculatorUtils;

/**
 *
 * @author animusanima
 */
public final class TipCalculator 
{
    private double billAmount;
    private double tipRate;

    public TipCalculator() {
        this(0.0, 0.0);
    }

    public TipCalculator(double billAmount, double tipRate) 
            throws IllegalArgumentException
    {
        this.billAmount = billAmount;
        this.tipRate = tipRate;
    }
    
    public void updateBillAmount(double amount)
    {
        this.billAmount = amount;
    }
    
    public void updateTipRate(double rate)
    {
        this.tipRate = rate;
    }
   
    /**
     * @return the billAmount
     */
    public double currentBillAmount() {
        return billAmount;
    }

    /**
     * @return the tipRate
     */
    public double currentTipRate() {
        return tipRate;
    }
    
    public double calculateTip()
    {
        return CalculatorUtils.calculateTip(billAmount, tipRate);
    }
    
    public double calculateTotal()
    {
        return CalculatorUtils.calculateTotal(billAmount, calculateTip());
    }
}