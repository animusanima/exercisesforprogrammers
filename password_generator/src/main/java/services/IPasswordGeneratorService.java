package services;

public interface IPasswordGeneratorService {
    String generatePassword();
    int getDesiredPasswordLength();
    void setDesiredPasswordLength(int desiredPasswordLength);
    int getNumberOfSpecialCharacters();
    void setNumberOfSpecialCharacters(int numberOfSpecialCharacters);
    int getAmountOfNumbers();
    void setAmountOfNumbers(int amountOfNumbers);
}