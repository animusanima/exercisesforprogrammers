/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author animusanima
 */
public class CalculatorUtils 
{    
    private static BigDecimal roundHelper;
    
    public static double determineTip(String billAmount, String tipRate) throws NumberFormatException 
    {       
        double billAmountNumber = convertBillAmountToNumber(billAmount);        
        int rateNumber = convertTipRateToNumber(tipRate);           
        
        roundHelper = BigDecimal.valueOf(billAmountNumber * calculateTipRate(rateNumber));
        roundHelper = roundToLastTwoDigits(roundHelper);
        return roundHelper.doubleValue();
    }           
    
    public static double convertBillAmountToNumber(String billAmount) 
            throws NumberFormatException, IllegalArgumentException
    {
        if (billAmount == null || billAmount.isEmpty())
            throw new IllegalArgumentException("Bill amount as String could not be null or empty.");
        
        double billAmountNumber;
        try
        {
            billAmountNumber = Double.valueOf(billAmount);
        }
        catch (Exception e)
        {
            throw new NumberFormatException(String.format("billAmount is not a number."));
        }

        if (billAmountNumber < 0)
            throw new IllegalArgumentException("Bill amount could not be negative.");

        return billAmountNumber;
    }    

    public static int convertTipRateToNumber(String rate) 
            throws NumberFormatException, IllegalArgumentException
    {
        if (rate == null || rate.isEmpty())
            throw new IllegalArgumentException("Tip rate as String cannot be null or empty.");
        
        int rateNumber;
        try 
        {
            rateNumber = Integer.valueOf(rate);
        }
        catch (Exception e) 
        {
            throw new NumberFormatException(String.format("Tip rate is not a number."));
        }
        
        if (rateNumber < 0)
            throw new IllegalArgumentException("Tip rate could not be negative.");
        
        return rateNumber;
    }   
    
    public static double calculateTotal(String billAmount, String tip)
    {        
        double billAmountNumber = convertBillAmountToNumber(billAmount);
        double tipNumber = convertBillAmountToNumber(tip);
        return billAmountNumber + tipNumber;
    }

    private static double calculateTipRate(int rate)
    {
        return ((double) rate / 100);
    }        

    private static BigDecimal roundToLastTwoDigits(final BigDecimal roundHelper) 
    {
        return roundHelper.setScale(2, RoundingMode.HALF_UP);
    }    

}