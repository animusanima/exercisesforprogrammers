package utils;

/**
 *
 * @author animusanima
 */
public final class ConversionUtils 
{        
    public static double convertToDouble(String value) 
            throws NumberFormatException
    {
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
}