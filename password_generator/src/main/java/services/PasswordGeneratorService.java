package services;

import enums.PasswordCharacterType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGeneratorService implements IPasswordGeneratorService {

    private int desiredPasswordLength;
    private int numberOfSpecialCharacters;
    private int amountOfNumbers;

    private final int SPECIAL_CHAR_CHARACTER_TYPE = 0;
    private final int NUMBER_CHARACTER_TYPE = 1;
    private final int NORMAL_CHARACTER_TYPE = 2;

    private ICharacterGenerator generator;
    private final Random RANDOMIZER = new Random();

    private List<Character> generatedCharacters;
    private List<Character> generatedSpecialCharacters;
    private List<Character> generatedNumbers;

    public PasswordGeneratorService() {
        this(new SimpleCharacterGenerator());
    }

    public PasswordGeneratorService(ICharacterGenerator generator) {
        this.generator = generator;
        this.desiredPasswordLength = 0;
        this.amountOfNumbers = 0;
        this.numberOfSpecialCharacters = 0;

        initialize();
    }

    private void initialize() {
        generatedCharacters = new ArrayList<>();
        generatedSpecialCharacters = new ArrayList<>();
        generatedNumbers = new ArrayList<>();
    }

    @Override
    public String generatePassword() {
        StringBuilder builder = new StringBuilder();
        resetCharacterLists();

        int wantedNumberOfCharacters = getDesiredPasswordLength();
        while (wantedNumberOfCharacters > 0) {
            switch (getRandomCharacterType()) {
                case SPECIAL_CHAR_CHARACTER_TYPE:
                    if (canStillAddSpecialCharacters()) {
                        Character specialChar = generator.generateRandomSpecialCharacter();
                        while (isNotUnique(specialChar, generatedSpecialCharacters)) {
                            specialChar = generator.generateRandomSpecialCharacter();
                        }
                        generatedSpecialCharacters.add(specialChar);

                        builder.append(specialChar);
                        numberOfSpecialCharacters--;
                        wantedNumberOfCharacters--;
                    }
                    break;
                case NUMBER_CHARACTER_TYPE:
                    if (canStillAddNumbers()) {
                        Character numberChar = generator.generateRandomNumber();
                        while (isNotUnique(numberChar, generatedNumbers)) {
                            numberChar = generator.generateRandomNumber();
                        }
                        generatedNumbers.add(numberChar);

                        builder.append(numberChar);
                        amountOfNumbers--;
                        wantedNumberOfCharacters--;
                    }
                    break;
                case NORMAL_CHARACTER_TYPE:
                    Character normalChar = generator.generateRandomCharacter();
                    while (isNotUnique(normalChar, generatedCharacters)) {
                        normalChar = generator.generateRandomCharacter();
                    }
                    generatedCharacters.add(normalChar);

                    builder.append(normalChar);
                    wantedNumberOfCharacters--;

                    break;
            }
        }
        return builder.toString();
    }

    private PasswordCharacterType getRandomCharacterType() {
        int randomValue = RANDOMIZER.nextInt(3);
        if (randomValue == PasswordCharacterType.SPECIAL_CHAR_CHARACTER_TYPE.ordinal()) {
            return PasswordCharacterType.SPECIAL_CHAR_CHARACTER_TYPE;
        } else if (randomValue == PasswordCharacterType.NUMBER_CHARACTER_TYPE.ordinal()) {
            return PasswordCharacterType.NUMBER_CHARACTER_TYPE;
        }
        return PasswordCharacterType.NORMAL_CHARACTER_TYPE;
    }

    private boolean isNotUnique(Character character, List<Character> characterList) {
        return characterList.contains(character);
    }

    private void resetCharacterLists() {
        generatedCharacters.clear();
        generatedSpecialCharacters.clear();
        generatedNumbers.clear();
    }

    private boolean canStillAddNumbers() {
        return amountOfNumbers > 0;
    }

    private boolean canStillAddSpecialCharacters() {
        return numberOfSpecialCharacters > 0;
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