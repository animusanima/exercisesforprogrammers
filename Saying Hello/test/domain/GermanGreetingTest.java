package domain;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GermanGreetingTest {

    @Test
    public void testRun() {
        GermanGreeting sut = new GermanGreeting("Mini Me");
        assertThat(sut.getGreeting(), is("Hallo Mini Me, schön dich zu sehen!"));
    }
}
