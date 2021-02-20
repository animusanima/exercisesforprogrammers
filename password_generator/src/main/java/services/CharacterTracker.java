package services;

import java.util.ArrayList;
import java.util.List;

public class CharacterTracker implements ICharacterTracker {

    protected List<Character> characterList;
    protected int characterLimit;

    public CharacterTracker(int characterLimit) {
        this.characterLimit = characterLimit;
        this.characterList = new ArrayList<>();
    }

    @Override
    public boolean canAddCharacter() {
        return characterList.size() < characterLimit;
    }

    @Override
    public boolean characterAlreadyAdded(Character character) {
        return characterList.contains(character);
    }

    @Override
    public void trackCharacter(Character character) {
        characterList.add(character);
    }

    @Override
    public Character getLastTrackedCharacter() {
        return characterList.get(characterList.size() - 1);
    }
}