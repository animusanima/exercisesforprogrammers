package services;

import utils.PasswordCharacterTypeRandomizer;

import java.util.ArrayList;
import java.util.List;

public class PasswordGeneratorService implements IPasswordGeneratorService {

    private int desiredPasswordLength;
    private int desiredAmountOfSpecialCharacters;
    private int desiredAmountOfNumberCharacters;

    private final ICharacterGenerator generator;

    private ICharacterTracker specialCharacterTracker;
    private ICharacterTracker numberCharacterTracker;
    private ICharacterTracker normalCharacterTracker;

    public PasswordGeneratorService() {
        this(new CharacterGenerator());
    }

    public PasswordGeneratorService(ICharacterGenerator generator) {
        this.generator = generator;
        this.desiredPasswordLength = 0;
        this.desiredAmountOfNumberCharacters = 0;
        this.desiredAmountOfSpecialCharacters = 0;
    }

    private int calculateAmountOfNormalCharacters() {
        return desiredPasswordLength - desiredAmountOfSpecialCharacters - desiredAmountOfNumberCharacters;
    }

    @Override
    public String generatePassword() {
        return generateCharactersUntilDesiredPasswordLengthIsReached();
    }

    @Override
    public List<String> generatePasswords(int amountOfPasswords) {
        List<String> results = new ArrayList<>();
        while (amountOfPasswords > 0) {
            results.add(generatePassword());
            amountOfPasswords--;
        }
        return results;
    }

    private String generateCharactersUntilDesiredPasswordLengthIsReached() {
        StringBuilder builder = new StringBuilder();
        initializeCharacterTracker();
        while (!desiredPasswordLengthReached(builder)) {
            switch (PasswordCharacterTypeRandomizer.getRandomCharacterType()) {
                case SPECIAL_CHARACTER_TYPE:
                    if (specialCharacterTracker.canAddCharacter()) {
                        generateSpecialCharacter(builder);
                    }
                    break;
                case NUMBER_CHARACTER_TYPE:
                    if (numberCharacterTracker.canAddCharacter()) {
                        generateNumberCharacter(builder);
                    }
                    break;
                case NORMAL_CHARACTER_TYPE:
                    if (normalCharacterTracker.canAddCharacter()) {
                        generateCharacter(builder);
                    }
                    break;
            }
        }
        return builder.toString();
    }

    private void generateCharacter(StringBuilder builder) {
        Character normalChar = generator.generateRandomCharacter();
        normalCharacterTracker.trackCharacter(generator.randomlyReplaceUpperCaseVowelWithNumber(normalChar));
        builder.append(normalCharacterTracker.getLastTrackedCharacter());
    }

    private void generateSpecialCharacter(StringBuilder builder) {
        Character specialChar = generator.generateRandomSpecialCharacter();
        specialCharacterTracker.trackCharacter(specialChar);
        builder.append(specialCharacterTracker.getLastTrackedCharacter());
    }

    private void generateNumberCharacter(StringBuilder builder) {
        Character numberChar = generator.generateRandomNumber();
        numberCharacterTracker.trackCharacter(numberChar);
        builder.append(numberCharacterTracker.getLastTrackedCharacter());
    }

    private void initializeCharacterTracker() {
        specialCharacterTracker = new CharacterTracker(getDesiredAmountOfSpecialCharacters());
        numberCharacterTracker = new CharacterTracker(getDesiredAmountOfNumberCharacters());
        normalCharacterTracker = new CharacterTracker(calculateAmountOfNormalCharacters());
    }

    private boolean desiredPasswordLengthReached(StringBuilder builder) {
        return builder.length() == getDesiredPasswordLength();
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
    public int getDesiredAmountOfSpecialCharacters() {
        return desiredAmountOfSpecialCharacters;
    }

    @Override
    public void setDesiredAmountOfSpecialCharacters(int desiredAmountOfSpecialCharacters) {
        this.desiredAmountOfSpecialCharacters = desiredAmountOfSpecialCharacters;
    }

    @Override
    public int getDesiredAmountOfNumberCharacters() {
        return desiredAmountOfNumberCharacters;
    }

    @Override
    public void setDesiredAmountOfNumberCharacters(int desiredAmountOfNumberCharacters) {
        this.desiredAmountOfNumberCharacters = desiredAmountOfNumberCharacters;
    }
}