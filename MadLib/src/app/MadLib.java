package app;

import builder.OutputBuilder;
import prompter.MadLibPrompter;
import reader.ConsoleReader;

/**
 *
 * @author animusanima
 */
public class MadLib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        MadLibPrompter.promptFor("noun");
        String noun = ConsoleReader.readInput();
        
        MadLibPrompter.promptFor("verb");
        String verb = ConsoleReader.readInput();
        
        MadLibPrompter.promptFor("adverb");
        String adverb = ConsoleReader.readInput();
        
        MadLibPrompter.promptFor("adjective");
        String adjective = ConsoleReader.readInput();        
        
        System.out.println(OutputBuilder.buildStory("Do you %s your %s %s %s? That's hilarious!", 
                noun, verb, adverb, adjective));
    }
    
}