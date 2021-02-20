package enums;

public enum PasswordCharacterType {

    SPECIAL_CHARACTER_TYPE(0),
    NUMBER_CHARACTER_TYPE(1),
    NORMAL_CHARACTER_TYPE(2);

    private int type;

    PasswordCharacterType(int type) {
        this.type = type;
    }

}