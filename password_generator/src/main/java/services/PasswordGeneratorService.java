package services;

import utils.PasswordCharacterTypeRandomizer;

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

    private String generateCharactersUntilDesiredPasswordLengthIsReached() {
        StringBuilder builder = new StringBuilder();
        initializeCharacterTracker();
        while (!desiredPasswordLengthReached(builder)) {
            switch (PasswordCharacterTypeRandomizer.getRandomCharacterType()) {
                case SPECIAL_CHARACTER_TYPE:
                    generateUniqueSpecialCharacter(builder);
                    break;
                case NUMBER_CHARACTER_TYPE:
                    generateUniqueNumberCharacter(builder);
                    break;
                default:
                    generateUniqueNormalCharacter(builder);
                    break;
            }
        }
        return builder.toString();
    }

    private void generateUniqueNormalCharacter(StringBuilder builder) {
        if (normalCharacterTracker.canAddCharacter()) {
            Character normalChar = generator.generateRandomCharacter();
            while (normalCharacterTracker.characterAlreadyAdded(normalChar)) {
                normalChar = generator.generateRandomCharacter();
            }
            normalCharacterTracker.trackCharacter(normalChar);
            builder.append(normalCharacterTracker.getLastTrackedCharacter());
        }
    }

    private void generateUniqueSpecialCharacter(StringBuilder builder) {
        if (specialCharacterTracker.canAddCharacter()) {
            Character specialChar = generator.generateRandomSpecialCharacter();
            while (specialCharacterTracker.characterAlreadyAdded(specialChar)) {
                specialChar = generator.generateRandomSpecialCharacter();
            }
            specialCharacterTracker.trackCharacter(specialChar);
            builder.append(specialCharacterTracker.getLastTrackedCharacter());
        }
    }

    private void generateUniqueNumberCharacter(StringBuilder builder) {
        if (numberCharacterTracker.canAddCharacter()) {
            Character numberChar = generator.generateRandomNumber();
            while (numberCharacterTracker.characterAlreadyAdded(numberChar)) {
                numberChar = generator.generateRandomNumber();
            }
            numberCharacterTracker.trackCharacter(numberChar);
            builder.append(numberCharacterTracker.getLastTrackedCharacter());
        }
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