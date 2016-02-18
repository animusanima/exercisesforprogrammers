package domain;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EnglishGreetingTest {

    @Test
    public void testRun() {
        EnglishGreeting sut = new EnglishGreeting("Mini Me");
        assertThat(sut.getGreeting(), is("Hello Mini Me, nice to meet you!"));
    }
}
