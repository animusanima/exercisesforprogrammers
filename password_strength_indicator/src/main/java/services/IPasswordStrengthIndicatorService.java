package services;

import enumerations.PasswordStrength;

public interface IPasswordStrengthIndicatorService {
    PasswordStrength measurePasswordStrength(String password);
}