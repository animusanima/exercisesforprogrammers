package persistency;

import domain.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class InMemoryGreetingsRepositoryTest {

    @Before
    public void setUp() {
        sut = new InMemoryGreetingsRepository();
    }

    @Test
    public void getGreetingByName_returnsGreeting() {
        final UserGreeting expectedGreeting = new EnglishGreeting("Joe");
        sut.add(expectedGreeting);
        assertThat(sut.getGreetingByUserName("Joe"), is(expectedGreeting));
    }

    @Test
    public void getGreetingByName_returnsNullIfUnkownName() {
        assertNull(sut.getGreetingByUserName("Unknown Name"));
    }

    private InMemoryGreetingsRepository sut; // sut = system under test
}
