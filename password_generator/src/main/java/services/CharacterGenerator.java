package services;

import enums.PasswordCharacterType;
import utils.PasswordCharacterUtils;

import java.util.Random;

public class CharacterGenerator implements ICharacterGenerator {

    private final Random RANDOMIZER = new Random();

    @Override
    public Character generateRandomNumber() {
        return PasswordCharacterUtils.getRandomNumber();
    }

    @Override
    public Character generateRandomCharacter() {
        return RANDOMIZER.nextBoolean() ? generateRandomLowerCaseCharacter() : generateRandomUpperCaseCharacter();
    }

    @Override
    public Character generateRandomLowerCaseCharacter() {
        return PasswordCharacterUtils.getRandomLowerCaseCharacter();
    }

    @Override
    public Character generateRandomUpperCaseCharacter() {
        return PasswordCharacterUtils.getRandomUpperCaseCharacter();
    }

    @Override
    public Character generateRandomSpecialCharacter() {
        return PasswordCharacterUtils.getRandomSpecialCharacter();
    }

    @Override
    public Character randomlyReplaceUpperCaseVowelWithNumber(Character character) {
        return PasswordCharacterUtils.randomlyReplaceUpperCaseVowelWithNumber(character);
    }
}