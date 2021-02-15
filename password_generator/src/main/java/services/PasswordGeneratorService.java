package services;

public class PasswordGeneratorService implements IPasswordGeneratorService {

    private int minimumLength;
    private int numberOfSpecialCharacters;
    private int amountOfNumbers;

    public PasswordGeneratorService(int minimumLength, int numberOfSpecialCharacters, int amountOfNumbers) {
        this.minimumLength = minimumLength;
        this.numberOfSpecialCharacters = numberOfSpecialCharacters;
        this.amountOfNumbers = amountOfNumbers;
    }

    @Override
    public String generatePassword() {
        String result = "";
        for (int i = 0; i < minimumLength; i++) {
            if (numberOfSpecialCharacters > 0) {
                numberOfSpecialCharacters--;
            }

            if (amountOfNumbers > 0) {
                amountOfNumbers--;
            }
        }
        return result;
    }

    public int getMinimumLength() {
        return minimumLength;
    }

    public void setMinimumLength(int minimumLength) {
        this.minimumLength = minimumLength;
    }

    public int getNumberOfSpecialCharacters() {
        return numberOfSpecialCharacters;
    }

    public void setNumberOfSpecialCharacters(int numberOfSpecialCharacters) {
        this.numberOfSpecialCharacters = numberOfSpecialCharacters;
    }

    public int getAmountOfNumbers() {
        return amountOfNumbers;
    }

    public void setAmountOfNumbers(int amountOfNumbers) {
        this.amountOfNumbers = amountOfNumbers;
    }
}