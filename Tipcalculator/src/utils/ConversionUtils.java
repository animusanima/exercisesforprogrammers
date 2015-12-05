/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author animusanima
 */
public final class ConversionUtils 
{        
    public static double safeConvertToDouble(String value) 
            throws NumberFormatException
    {
        if (isNullOrEmpty(value))
            return zeroIfNonValid();
        try 
        {
            return Double.valueOf(value);            
        } catch (NumberFormatException numEx)             
        {
            throw new NumberFormatException("Value must be a number.");
        }
    }   
    
    public static double convertTipRateToDouble(double percentagerate)
    {
        return (percentagerate / 100);
    }
    
    private static boolean isNullOrEmpty(String value)
    {        
        return (value == null || value.isEmpty());
    }
    
    private static double zeroIfNonValid()
    {
        return 0.0;
    }
}