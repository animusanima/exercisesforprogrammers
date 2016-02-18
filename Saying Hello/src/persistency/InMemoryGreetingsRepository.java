package persistency;

import domain.*;
import java.util.HashMap;

public final class InMemoryGreetingsRepository implements GreetingsRepository {

    public InMemoryGreetingsRepository() {
        greetings = new HashMap<>();
    }

    @Override
    public void add(UserGreeting greeting) {
        if (!greetings.containsKey(greeting.getUserName())) {
            greetings.put(greeting.getUserName(), greeting);
        }
    }

    @Override
    public UserGreeting getGreetingByUserName(String userName) {
        return greetings.get(userName);
    }

    private final HashMap<String, UserGreeting> greetings;
}
