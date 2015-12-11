package services;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author animusanima
 */
public final class ConsoleGreeterService 
{
    private final static HashMap<String, String> GREETINGS = new HashMap<>();
    
    public static void addGreeting(String name, String greeting)
    {
        if (!GREETINGS.containsKey(name))
            GREETINGS.put(name, greeting);
    }
    
    public static int numberOfGreetings()
    {
        return GREETINGS.size();
    }
    
    public static String getGreetingForName(String name)
    {
        return GREETINGS.get(name);
    }
    
    public static void clearAllGreetings()
    {
        GREETINGS.clear();
    }
}