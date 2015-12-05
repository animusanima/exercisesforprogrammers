/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author animusanima
 */
public final class DoubleValidator 
{    
    private static boolean isNegative(double value)
    {        
        return (BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue() 
                < BigDecimal.valueOf(0.0).setScale(2, RoundingMode.HALF_UP).doubleValue());
    }
    
    public static boolean validate(double value) throws IllegalArgumentException
    {
        if (isNegative(value))
            throw new IllegalArgumentException("Value must be positive.");
        return true;
    }        
}