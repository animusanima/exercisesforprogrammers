package prompter;

import builder.OutputBuilder;

/**
 *
 * @author animusanima
 */
public final class MadLibPrompter 
{   
    public static void promptFor(String input)
    {
        System.out.print(OutputBuilder.buildPromptMessage(input));
    }
}