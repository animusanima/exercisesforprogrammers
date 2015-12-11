package greeterTests;

import greeters.ConsoleGreeter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author animusanima
 */
public class ConsoleGreeterTest 
{    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public ConsoleGreeterTest() {
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
    public void nameWillBeUsedForGreeting() 
    {
        ConsoleGreeter.greet("Joe");
        assertThat("Hello Joe, nice to meet you.\r\n", is(outContent.toString()));
    }
    
    @Test
    public void promptForName()
    {
        ConsoleGreeter.promptForName();
        assertThat("What is your name? ", is(outContent.toString()));
    }
            
}