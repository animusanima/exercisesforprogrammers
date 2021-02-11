package services;

import enumerations.PasswordStrength;
import org.apache.commons.lang3.StringUtils;
import utils.PasswordUtils;

import java.text.MessageFormat;

public class PasswordStrengthIndicatorService implements IPasswordStrengthIndicatorService {
    @Override
    public PasswordStrength measurePasswordStrength(String password) {
        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException(MessageFormat.format("Password strength can not be measured for {0} value", password == null ? "null" : "empty"));
        }

        if (PasswordUtils.containsSpecialCharacters(password) && PasswordUtils.containsAtLeastOneNumber(password) && PasswordUtils.containsLetters(password) && PasswordUtils.lengthIsAtLeastNumberOfCharactersLong(password, PasswordUtils.MINIMUM_LENGTH_STRONG_PASSWORD)) {
            return PasswordStrength.VERY_STRONG;
        } else if (PasswordUtils.containsLetters(password) && PasswordUtils.containsAtLeastOneNumber(password) && PasswordUtils.lengthIsAtLeastNumberOfCharactersLong(password, PasswordUtils.MINIMUM_LENGTH_STRONG_PASSWORD) && !PasswordUtils.containsSpecialCharacters(password)) {
            return PasswordStrength.STRONG;
        } else if (PasswordUtils.containsOnlyLetters(password) && PasswordUtils.lengthSmallerThanDefined(password, PasswordUtils.MINIMUM_LENGTH_WEAK_PASSWORDS)) {
            return PasswordStrength.WEAK;
        }
        return PasswordStrength.VERY_WEAK;
    }
}
