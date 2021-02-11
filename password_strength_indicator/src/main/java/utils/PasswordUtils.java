package utils;

public class PasswordUtils {
    public static final int MINIMUM_LENGTH_WEAK_PASSWORDS = 8;
    public static final int MINIMUM_LENGTH_STRONG_PASSWORD = 8;

    public static boolean lengthSmallerThanDefined(String password, int definedLength) {
        return password.length() < definedLength;
    }
    public static boolean containsOnlyNumbers(String password) {
        return password.matches("[\\d]+");
    }

    public static boolean containsOnlyLetters(String password) {
        return password.matches("[a-zA-Z]+");
    }

    public static boolean lengthIsAtLeastNumberOfCharactersLong(String password, int minimumLength) {
        return password.length() >= minimumLength;
    }

    public static boolean containsAtLeastOneNumber(String password) {
        for (Character c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsLetters(String password) {
        for (Character c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsNumbers(String password) {
        for (Character c : password.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsSpecialCharacters(String password) {
        for (Character c : password.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }
}