package presentation;

import domain.*;
import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class ConsoleUserInterfaceTest {

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setIn(consoleMock);
        sut = new ConsoleUserInterface();
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    public void displayGreeting() {
        sut.displayGreeting(new EnglishGreeting("Joe"));
        assertThat("Hello Joe, nice to meet you!\r\n", is(outContent.toString()));
    }

    @Test
    public void getUserName() {
        String userName = sut.getUserName();

        assertThat(userName, is("Joe"));
        assertThat("What is your name? ", is(outContent.toString()));
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream consoleMock = new ByteArrayInputStream("Joe\r\n".getBytes());

    private ConsoleUserInterface sut;
}
