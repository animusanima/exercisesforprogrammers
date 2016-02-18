package persistency;

import domain.*;

public interface GreetingsRepository {

    void add(UserGreeting greeting);

    UserGreeting getGreetingByUserName(String name);
}
