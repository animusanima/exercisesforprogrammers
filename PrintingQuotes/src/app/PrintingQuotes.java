/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Scanner;
import prompter.ConsolePrompter;
import writer.ConsoleQuoteWriter;

/**
 *
 * @author animusanima
 */
public class PrintingQuotes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConsolePrompter.askForQuote();
        
        Scanner in = new Scanner(System.in);
        String quote = in.nextLine();
        
        ConsolePrompter.askForAuthor();
        String author = in.nextLine();
        
        String quoteAndAuthor = ConsoleQuoteWriter.format(author, quote);
        System.out.println(quoteAndAuthor);
    }
    
}