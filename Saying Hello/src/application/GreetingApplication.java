package application;

import domain.*;
import persistency.*;

public class GreetingApplication {

    public GreetingApplication(GreetingsRepository greetingsRepository, UserInterface userInterface) {
        this.greetingsRepository = greetingsRepository;
        this.userInterface = userInterface;
    }

    public void initialize() {
        greetingsRepository.add(new EnglishGreeting("Joe"));
        greetingsRepository.add(new SpanishGreeting("Juan"));
        greetingsRepository.add(new GermanGreeting("Michael"));
    }

    public void run() {
        greetUser();
        greetUser();
        greetUser();
    }

    private void greetUser() {
        String userName = userInterface.getUserName();
        UserGreeting greeting = greetingsRepository.getGreetingByUserName(userName);
        userInterface.displayGreeting(greeting);
    }

    private final GreetingsRepository greetingsRepository;
    private final UserInterface userInterface;
}
