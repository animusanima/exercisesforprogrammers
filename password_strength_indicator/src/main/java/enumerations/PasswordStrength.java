package enumerations;

public enum PasswordStrength {
    VERY_WEAK("Very weak", 0),
    WEAK("Weak", 1),
    STRONG("Strong", 2),
    VERY_STRONG("Very strong", 3);

    String description;
    int value;

    PasswordStrength(String description, int value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return this.description;
    }

    public int getValue() {
        return this.value;
    }
}
