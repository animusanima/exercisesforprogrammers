package domain;

public abstract class UserGreeting  {

    protected UserGreeting(String userName, String greedingText) {
        this.userName = userName;
        this.greedingText = greedingText;
    }

    public String getUserName() {
        return userName;
    }

    public String getGreeting() {
        return String.format(greedingText, userName);
    }

    private final String userName;
    private final String greedingText;
}
