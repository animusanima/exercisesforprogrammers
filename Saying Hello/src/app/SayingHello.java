package app;

import greeters.ConsoleGreeter;
import reader.ConsoleReader;
import services.ConsoleGreeterService;

/**
 *
 * @author animusanima
 */
public final class SayingHello 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ConsoleGreeterService.addGreeting("Joe", "Hello %s, nice to meet you!");
        ConsoleGreeterService.addGreeting("Juan", "Hola %s, encantada de conocerte!");
        ConsoleGreeterService.addGreeting("Michael", "Hallo %s, schön dich zu sehen!");
        
        ConsoleGreeter.promptForName();
        ConsoleGreeter.greet(ConsoleReader.readNextLine());
        
        ConsoleGreeter.promptForName();
        ConsoleGreeter.greet(ConsoleReader.readNextLine());
        
        ConsoleGreeter.promptForName();
        ConsoleGreeter.greet(ConsoleReader.readNextLine());
    }
    
}