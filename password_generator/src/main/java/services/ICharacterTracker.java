package services;

public interface ICharacterTracker {
    boolean canAddCharacter();
    boolean characterAlreadyAdded(Character character);
    void trackCharacter(Character character);
    Character getLastTrackedCharacter();
}