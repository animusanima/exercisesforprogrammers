package services;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;

public class CharacterTrackerTest {
    private ICharacterTracker tracker;

    @BeforeMethod
    public void init() {
        tracker = new CharacterTracker(0);
    }

    @Test
    public void should_evaluate_if_character_can_be_added() {
        tracker = new CharacterTracker(1);
        assertThat(tracker.canAddCharacter()).isTrue();
    }

    @Test
    public void should_evaluate_if_character_can_not_be_added() {
        assertThat(tracker.canAddCharacter()).isFalse();
    }

    @Test
    public void should_track_added_character() {
        ICharacterTracker trackerMock = Mockito.mock(ICharacterTracker.class);

        ArgumentCaptor<Character> charCapture = ArgumentCaptor.forClass(Character.class);
        doNothing().when(trackerMock).trackCharacter(charCapture.capture());
        trackerMock.trackCharacter('a');

        assertThat('a').isEqualTo(charCapture.getValue());
    }

    @Test
    public void should_recognize_already_added_characters() {
        tracker = new CharacterTracker(1);
        tracker.trackCharacter('a');
        assertThat(tracker.characterAlreadyAdded('a')).isTrue();
    }

    @Test
    public void should_return_last_tracked_character() {
        tracker = new CharacterTracker(1);
        tracker.trackCharacter('a');
        assertThat(tracker.getLastTrackedCharacter()).isEqualTo('a');
    }

}