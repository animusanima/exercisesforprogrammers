package counter;

import validator.InputValidator;

/**
 *
 * @author animusanima
 */
public final class CharacterCounter 
{
    public static int lengthOf(String input)
    {
        if (InputValidator.isNullOrEmpty(input))
            return 0;
        return input.length();
    }
}