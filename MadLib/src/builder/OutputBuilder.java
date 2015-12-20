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
    
    public static String buildStory(String template, String noun, String verb, String adverb, 
            String adjective)
    {
        return String.format(template, verb, adverb, noun, adjective);
    }

    private static String determineArticleFor(String input)
    {
        return input.toLowerCase().startsWith("a") ? "an" : "a";
    }
}