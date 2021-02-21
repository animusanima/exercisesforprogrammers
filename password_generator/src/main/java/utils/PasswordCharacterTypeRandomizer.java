package utils;

import enums.PasswordCharacterType;

import java.util.Random;

public class PasswordCharacterTypeRandomizer {

    private final static Random RANDOMIZER = new Random();

    public static PasswordCharacterType getRandomCharacterType() {
        int randomValue = RANDOMIZER.nextInt(3);
        if (randomValue == PasswordCharacterType.SPECIAL_CHARACTER_TYPE.getValue()) {
            return PasswordCharacterType.SPECIAL_CHARACTER_TYPE;
        } else if (randomValue == PasswordCharacterType.NUMBER_CHARACTER_TYPE.getValue()) {
            return PasswordCharacterType.NUMBER_CHARACTER_TYPE;
        }
        return PasswordCharacterType.NORMAL_CHARACTER_TYPE;
    }
}