package domain;

public class SpanishGreeting extends UserGreeting {

    public SpanishGreeting(String userName) {
        super(userName, "Hola %s, encantada de conocerte!");
    }
}
