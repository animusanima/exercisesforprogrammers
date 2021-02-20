package services;

public interface IPasswordGeneratorService {
    String generatePassword();
    int getDesiredPasswordLength();
    void setDesiredPasswordLength(int desiredPasswordLength);
    int getDesiredAmountOfSpecialCharacters();
    void setDesiredAmountOfSpecialCharacters(int desiredAmountOfSpecialCharacters);
    int getDesiredAmountOfNumberCharacters();
    void setDesiredAmountOfNumberCharacters(int desiredAmountOfNumberCharacters);
}