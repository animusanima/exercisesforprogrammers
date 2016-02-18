package domain;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpanishGreetingTest {

    @Test
    public void testRun() {
        SpanishGreeting sut = new SpanishGreeting("Mini Me");
        assertThat(sut.getGreeting(), is("Hola Mini Me, encantada de conocerte!"));
    }
}
