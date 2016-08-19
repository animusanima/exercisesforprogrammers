/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author hinterseber
 */
public class MathResultFormatter 
{
    private static final String ADDITION_FORMAT = "%d + %d = %d";
    private static final String SUBTRACTION_FORMAT = "%d - %d = %d";
    private static final String MULTIPLICATION_FORMAT = "%d * %d = %d";
    private static final String DIVISION_FORMAT = "%d / %d = %d";
    private static final String LINE_BREAK = "\n";
    
    public static String printAddition(int number_one, int number_two, int result) {
        return print(String.format(ADDITION_FORMAT, number_one, number_two, result) + LINE_BREAK);
    }
    
    public static String printSubtraction(int number_one, int number_two, int result) {
        return print(String.format(SUBTRACTION_FORMAT, number_one, number_two, result) + LINE_BREAK);
    }

    public static String printMultiplication(int number_one, int number_two, int result) {
        return print(String.format(MULTIPLICATION_FORMAT, number_one, number_two, result) + LINE_BREAK);
    }

    public static String printDivision(int number_one, int number_two, int result) {
        return String.format(DIVISION_FORMAT, number_one, number_two, result);
    }
    
    public static String print(String... line) {
        String result = "";
        for (String s : line) {
            result += (s.contains(LINE_BREAK) ? s : s + LINE_BREAK);
        }
        return result;
    }
}