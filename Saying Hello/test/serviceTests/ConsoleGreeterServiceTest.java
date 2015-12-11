package serviceTests;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import services.ConsoleGreeterService;

/**
 *
 * @author animusanima
 */
public class ConsoleGreeterServiceTest {
    
    public ConsoleGreeterServiceTest() {
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
    public void canAddGreetingToConsoleGreeterService()
    {
        ConsoleGreeterService.addGreeting("Joe", "Hello %s, nice to meet you!");
        assertThat(ConsoleGreeterService.numberOfGreetings(), is(1));
    }
    
    @Test
    public void canGetGreetingForName()
    {
        ConsoleGreeterService.addGreeting("Joe", "Hello %s, nice to meet you!");
        String greet = ConsoleGreeterService.getGreetingForName("Joe");
        assertNotNull(greet);                
    }
    
    @Test
    public void canClearGreetings()
    {
        ConsoleGreeterService.clearAllGreetings();
        assertThat(ConsoleGreeterService.numberOfGreetings(), is(0));
    }
    
    @Test
    public void singleGreetingCorrectlyReturnedByGetRandomGreeting()
    {   
        ConsoleGreeterService.clearAllGreetings();
        ConsoleGreeterService.addGreeting("Joe", "Hello %s, nice to meet you!");
        String greet = ConsoleGreeterService.getGreetingForName("Joe");
        assertThat("Hello %s, nice to meet you!", is(greet));
    }
    
}