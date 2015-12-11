package greeters;

import services.ConsoleGreeterService;

/**
 *
 * @author animusanima
 */
public final class ConsoleGreeter 
{
    public static void greet(String name)
    {
        System.out.println(String.format(ConsoleGreeterService.getGreetingForName(name), name));
    }
    
    public static void promptForName()
    {
        System.out.print("What is your name? ");
    }        
}