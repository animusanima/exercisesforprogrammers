/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import outputformatter.WordLengthFormatter;

/**
 *
 * @author animusanima
 */
public class WordLengthTest {
    
    public WordLengthTest() {
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
    public void whenStringIsEmptyFormatterSaysStringIsZeroCharsLong()
    {
        String result = callFormatterAndReturnFormattedString("");
        assertThat(result, is(" is 0 character long."));
    }
    
    @Test
    public void whenStringIsNullFormatterSaysStringIsZeroCharsLong()
    {
        String result = callFormatterAndReturnFormattedString(null);
        assertThat(result, is("null is 0 character long."));
    }
    
    @Test
    public void whenOneCharInputIsGivenFormmatterSaysItsOneCharLong()
    {
        String result = callFormatterAndReturnFormattedString("A");
        assertThat(result, is("A is 1 character long."));
    }
    
    @Test
    public void formatInputOfAnyLengthCorrectly()
    {
        StringBuilder builder = new StringBuilder();
        String result;
        boolean plural;
        
        for (int i = 1; i < 10; i++) 
        {
            builder.append(i);            
            result = callFormatterAndReturnFormattedString(builder.toString());
            plural = builder.length() > 1;
            if (plural)
                assertThatInputIsExpectedFormat(result, String.format("%s is %d characters long.", builder.toString(), i));
            else
                assertThatInputIsExpectedFormat(result, String.format("%s is %d character long.", builder.toString(), i));
        }    
    }

    private String callFormatterAndReturnFormattedString(String input) {
        return WordLengthFormatter.format(input);
    }
    
    private void assertThatInputIsExpectedFormat(String input, String expected)
    {
        assertThat(input, is(expected));
    }
    
}