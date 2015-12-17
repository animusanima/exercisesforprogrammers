/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import data.Quote;
import java.util.ArrayList;
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
    public static void main(String[] args) 
    {
        ConsolePrompter.askForQuote();        
        Scanner in = new Scanner(System.in);
        String quote = in.nextLine();
        
        ConsolePrompter.askForAuthor();
        String author = in.nextLine();
        
        String quoteAndAuthor = ConsoleQuoteWriter.format(author, quote);
        System.out.println(quoteAndAuthor);
        
        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("These aren't the droids you're looking for.", "Obi-Wan Kenobi"));
        quotes.add(new Quote("The best preparation for tomorrow is doing your best today.", "H. Jackson Brown Jr."));
        
        for (Quote q : quotes)
        {
            System.out.println(ConsoleQuoteWriter.format(q.getAuthor(), q.getQuotation()));
        }
    }
    
}
