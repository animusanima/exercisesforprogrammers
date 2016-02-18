package domain;

public class GermanGreeting extends UserGreeting {

    public GermanGreeting(String userName) {
        super(userName, "Hallo %s, schön dich zu sehen!");
    }
}
