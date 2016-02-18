package host;

import java.io.*;
import org.junit.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SayingHelloTests {

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setIn(consoleMock);
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    public void testRun() {
        SayingHello.main(null);

        assertThat("What is your name? "
                + "Hello Joe, nice to meet you!\r\n"
                + "What is your name? "
                + "Hola Juan, encantada de conocerte!\r\n"
                + "What is your name? "
                + "Hallo Michael, schön dich zu sehen!\r\n", is(outContent.toString()));
    }
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream consoleMock = new ByteArrayInputStream("Joe\r\nJuan\r\nMichael\r\n".getBytes());
}
