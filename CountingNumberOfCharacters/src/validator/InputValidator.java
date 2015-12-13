package validator;

/**
 *
 * @author animusanima
 */
public final class InputValidator 
{
    public static boolean validate(final String input) 
            throws IllegalArgumentException
    {
        if (isNullOrEmpty(input))
            throw new IllegalArgumentException("Please enter a valid input string.");
        return true;
    }
    
    public static boolean isNullOrEmpty(final String input)
    {
        return ( (input == null) || (input.isEmpty()) );
    }
}