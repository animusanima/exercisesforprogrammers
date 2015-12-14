package outputformatter;

import counter.CharacterCounter;

/**
 *
 * @author animusanima
 */
public final class WordLengthFormatter 
{
    private static boolean plural;
    private static final String SINGULAR_FORM = "%s is %d character long.";
    private static final String PLURAL_FORM = "%s is %d characters long.";
    
    public static String format(String word)
    {
        plural = CharacterCounter.lengthOf(word) > 1;
        return String.format(!plural ? SINGULAR_FORM : PLURAL_FORM, word, CharacterCounter.lengthOf(word));
    }
}