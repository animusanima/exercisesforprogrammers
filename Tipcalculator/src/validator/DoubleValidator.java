/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import utils.CalculatorUtils;

/**
 *
 * @author animusanima
 */
public final class DoubleValidator 
{    
    private static boolean isNegative(double value)
    {                
        return (CalculatorUtils.roundToNearestCent(value) < 0);
    }
    
    public static boolean validate(double value) throws IllegalArgumentException
    {
        if (isNegative(value))
            throw new IllegalArgumentException("Value must be positive.");
        return true;
    }        
}