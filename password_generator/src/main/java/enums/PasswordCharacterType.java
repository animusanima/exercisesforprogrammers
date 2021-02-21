package enums;

public enum PasswordCharacterType {

    SPECIAL_CHARACTER_TYPE(0),
    NUMBER_CHARACTER_TYPE(1),
    NORMAL_CHARACTER_TYPE(2);

    private int value;

    PasswordCharacterType(int type) {
        this.value = type;
    }

    public int getValue() {
        return value;
    }
}