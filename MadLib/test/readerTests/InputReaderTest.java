/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerTests;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reader.ConsoleReader;
import testConstants.TestConstants;

/**
 *
 * @author animusanima
 */
public class InputReaderTest 
{    
    private InputStream savedSystemIn;
    
    public InputReaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        savedSystemIn = System.in;
    }
    
    @After
    public void tearDown() {
        System.setIn(savedSystemIn);
    }    
    
    @Test
    public void canReadNounFromConsole()
    {
        WriteToConsole(TestConstants.NOUN);
        assertThat(ConsoleReader.readInput(), is(TestConstants.NOUN));
    }
    
    @Test
    public void canReadVerbFromConsole()
    {
        WriteToConsole(TestConstants.VERB);
        assertThat(ConsoleReader.readInput(), is(TestConstants.VERB));
    }

    @Test
    public void canReadAdverbFromConsole()
    {
        WriteToConsole(TestConstants.ADVERB);
        assertThat(ConsoleReader.readInput(), is((TestConstants.ADVERB)));
    }
    
    @Test
    public void canReadAdjectiveFromConsole()
    {
        WriteToConsole(TestConstants.ADJECTIVE);
        assertThat(ConsoleReader.readInput(), is(TestConstants.ADJECTIVE));
    }

    private void WriteToConsole(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }
    
}