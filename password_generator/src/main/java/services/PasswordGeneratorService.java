package services;

import java.util.Random;

public class PasswordGeneratorService implements IPasswordGeneratorService {

    private int desiredPasswordLength;
    private int numberOfSpecialCharacters;
    private int amountOfNumbers;

    private ICharacterGenerator generator;
    private final Random RANDOMIZER = new Random();

    public PasswordGeneratorService() {
        this(new SimpleCharacterGenerator());
    }

    public PasswordGeneratorService(ICharacterGenerator generator) {
        this.generator = generator;
        this.desiredPasswordLength = 0;
        this.amountOfNumbers = 0;
        this.numberOfSpecialCharacters = 0;
    }

    @Override
    public String generatePassword() {
        StringBuilder builder = new StringBuilder();
        int wantedNumberOfCharacters = getDesiredPasswordLength();
        while (wantedNumberOfCharacters > 0) {
            int valueToPick = RANDOMIZER.nextInt(3);
            switch (valueToPick) {
                case 0:
                    if (numberOfSpecialCharacters > 0) {
                        builder.append(generator.generateRandomSpecialCharacter());
                        numberOfSpecialCharacters--;
                        wantedNumberOfCharacters--;
                    }
                    break;
                case 1:
                    if (amountOfNumbers > 0) {
                        builder.append(generator.generateRandomNumber());
                        amountOfNumbers--;
                        wantedNumberOfCharacters--;
                    }
                    break;
                case 2:
                    builder.append(generator.generateRandomCharacter());
                    wantedNumberOfCharacters--;
                    break;
            }
        }
        return builder.toString();
    }

    @Override
    public int getDesiredPasswordLength() {
        return this.desiredPasswordLength;
    }

    @Override
    public void setDesiredPasswordLength(int desiredPasswordLength) {
        this.desiredPasswordLength = desiredPasswordLength;
    }

    @Override
    public int getNumberOfSpecialCharacters() {
        return numberOfSpecialCharacters;
    }

    @Override
    public void setNumberOfSpecialCharacters(int numberOfSpecialCharacters) {
        this.numberOfSpecialCharacters = numberOfSpecialCharacters;
    }

    @Override
    public int getAmountOfNumbers() {
        return amountOfNumbers;
    }

    @Override
    public void setAmountOfNumbers(int amountOfNumbers) {
        this.amountOfNumbers = amountOfNumbers;
    }
}