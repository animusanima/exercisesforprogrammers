package services;

import java.util.List;

public interface IPasswordGeneratorService {
    String generatePassword();
    List<String> generatePasswords(int amountOfPasswords);

    int getDesiredPasswordLength();
    void setDesiredPasswordLength(int desiredPasswordLength);
    int getDesiredAmountOfSpecialCharacters();
    void setDesiredAmountOfSpecialCharacters(int desiredAmountOfSpecialCharacters);
    int getDesiredAmountOfNumberCharacters();
    void setDesiredAmountOfNumberCharacters(int desiredAmountOfNumberCharacters);
}