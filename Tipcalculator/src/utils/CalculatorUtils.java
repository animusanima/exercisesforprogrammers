/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * roundHelper.setScale(2, RoundingMode.HALF_UP);
 * 
 * @author animusanima
 */
public final class CalculatorUtils 
{    
    private static BigDecimal roundingHelper;
    public static double calculateTip(double billAmount, double rate) 
    {
        return billAmount * calculateTipRate(rate);
    }
    
    public static double calculateTotal(double billAmount, double tip)
    {
        return billAmount + tip;
    }                
    
    public static double calculateTipRate(double percentageRate)
    {
        return ConversionUtils.convertTipRateToDouble(percentageRate);
    }
    
    public static double roundToNearestCent(double value)
    {
        roundingHelper = BigDecimal.valueOf(value);
        roundingHelper = roundingHelper.setScale(2, RoundingMode.HALF_UP);
        return roundingHelper.doubleValue();
    }
}