package services;

import java.util.List;

public interface ICharacterGenerator {
    Character generateRandomNumber();
    Character generateRandomCharacter();
    Character generateRandomLowerCaseCharacter();
    Character generateRandomUpperCaseCharacter();
    Character generateRandomSpecialCharacter();
    Character randomlyReplaceUpperCaseVowelWithNumber(Character character);
}
