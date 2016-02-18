package host;

import application.*;
import presentation.*;
import persistency.*;

public final class SayingHello {

    public static void main(String[] args) {
        GreetingsRepository repository = new InMemoryGreetingsRepository();
        UserInterface userInterface = new ConsoleUserInterface();
        GreetingApplication application = new GreetingApplication(repository, userInterface);

        try {
            application.initialize();
            application.run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}