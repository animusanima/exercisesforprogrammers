package prompterTests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static prompter.MadLibPrompter.promptFor;
import static builder.OutputBuilder.buildPromptMessage;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author animusanima
 */
public class PrompterTest 
{    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String[] inputs = new String[] {"noun", "verb", "adverb", "adjective"};
    
    public PrompterTest() {
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
    }
    
    @Test
    public void prompterProducesExpectedOutputs()
    {
        for (String input : inputs) 
        {
            String expectedOutput = buildPromptMessage(input);
            assertThatPrompterProducesRightOutput(input, expectedOutput);
        }
    }

    private void assertThatPrompterProducesRightOutput(String input, 
            String expected) 
    {
        promptFor(input);
        assertThat(outContent.toString(), is(expected));
        outContent.reset();
    }
    
}