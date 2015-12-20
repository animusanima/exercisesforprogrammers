/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerTests;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reader.ConsoleReader;

/**
 *
 * @author animusanima
 */
public class InputReaderTest 
{    
    private InputStream savedSystemIn;
    
    private final String ADJECTIVE = "beautiful";
    
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
    public void canSimulateInputFromUser()
    {
        WriteToConsole(ADJECTIVE);
        String userInput = ConsoleReader.readInput();
        assertThat(ADJECTIVE, is(userInput));
    }
    
    @Test
    public void canReadInputThroughtConsoleReader()
    {
        WriteToConsole(ADJECTIVE);
        String userInput = ConsoleReader.readInput();
        assertThat(userInput, is(ADJECTIVE));
    }

    private void WriteToConsole(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }
    
}