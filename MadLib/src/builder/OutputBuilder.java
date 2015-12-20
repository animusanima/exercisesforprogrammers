package builder;

/**
 *
 * @author animusanima
 */
public class OutputBuilder 
{
    public static String buildPromptMessage(String input)
    {
        return String.format("Enter %s %s: ", determineArticleFor(input), input);
    }
    
    private static String determineArticleFor(String input)
    {
        return input.toLowerCase().startsWith("a") ? "an" : "a";
    }
}