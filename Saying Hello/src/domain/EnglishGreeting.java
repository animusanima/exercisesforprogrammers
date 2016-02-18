package domain;

public class EnglishGreeting extends UserGreeting {

    public EnglishGreeting(String userName) {
        super(userName, "Hello %s, nice to meet you!");
    }
}
