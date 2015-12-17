/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prompttests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import prompter.ConsolePrompter;

/**
 *
 * @author animusanima
 */
public class PromptTest 
{
    // Streams
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    // String constants
    private static final String QUOTE_PROMPT_MESSAGE = "What is the quote? ";
    
    public PromptTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        
    }
    
    @After
    public void tearDown() {
        System.setOut(null);
    }
    
    @Test
    public void askTheUserForAQuote()
    {        
        ConsolePrompter.askForQuote();
        assertThat(QUOTE_PROMPT_MESSAGE, is(getConsoleOutput()));
    }    
    
    @Test
    public void askTheUserForAuthor()
    {
        ConsolePrompter.askForAuthor();
        assertThat("Who said it? ", is(getConsoleOutput()));
    }
    
    private String getConsoleOutput() {
        return outContent.toString();
    }
    
}