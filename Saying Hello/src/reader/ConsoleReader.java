package reader;

import java.util.Scanner;

/**
 *
 * @author animusanima
 */
public final class ConsoleReader 
{
    private static Scanner scan;
    public static String readNextLine()
    {
        try {
            scan = new Scanner(System.in);
            return scan.nextLine();
        } finally {
            scan = null;
        }
    }
}