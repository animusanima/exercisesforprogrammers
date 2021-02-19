package utils;

import java.util.Random;

public class PasswordCharacterUtils {

    public static final String NUMBERS = "0123456789";
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = LOWERCASE_CHARACTERS.toUpperCase();
    public static final String SPECIAL_CHARACTERS = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";

    private static final Random RANDOMIZER = new Random();

    public static char getRandomNumber() {
        return generateRandom(NUMBERS);
    }

    public static char getRandomLowerCaseCharacter() {
        return generateRandom(LOWERCASE_CHARACTERS);
    }

    public static char getRandomUpperCaseCharacter() {
        return generateRandom(UPPERCASE_CHARACTERS);
    }

    public static char getRandomSpecialCharacter() {
        return generateRandom(SPECIAL_CHARACTERS);
    }

    private static char generateRandom(String source) {
        return source.charAt(RANDOMIZER.nextInt(source.length()));
    }
}