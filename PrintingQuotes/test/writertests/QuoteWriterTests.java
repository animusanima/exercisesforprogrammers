/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writertests;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import writer.ConsoleQuoteWriter;

/**
 *
 * @author animusanima
 */
public class QuoteWriterTests {
    
    public QuoteWriterTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void canWriteQuoteWithGivenInput()
    {
        String quote = "These aren't the droids you're looking for.";
        String author = "Obi-Wan Kenobi";
        
        String output = ConsoleQuoteWriter.format(author, quote);        
        assertThat(output, is(author + " says, " + "\"" + quote + "\""));
    }
    
}