package reader;

import java.util.Scanner;

/**
 *
 * @author animusanima
 */
public final class ConsoleReader 
{
    private static Scanner s;
    public static String readInput()
    {
        try {
            s = new Scanner(System.in);
            return s.nextLine();
        } finally {
            s = null;
        }
    }
}