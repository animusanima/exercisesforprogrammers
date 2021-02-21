package services;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class CharacterGeneratorTest {

    private ICharacterGenerator generator;

    @BeforeMethod
    public void init() {
        generator = new CharacterGenerator();
    }

    @Test
    public void should_generate_random_numbers_which_are_not_null() {
        assertThat(generator.generateRandomNumber()).isNotNull();
    }

    @Test
    public void should_generate_random_numbers_between_zero_and_nine_inclusive() {
        assertThat(generator.generateRandomNumber()).isBetween('0', '9');
    }

    @Test
    public void should_generate_random_lowercase_characters_which_are_not_null() {
        assertThat(generator.generateRandomLowerCaseCharacter()).isNotNull();
    }

    @Test
    public void should_generate_random_lowercase_characters() {
        assertThat(generator.generateRandomLowerCaseCharacter()).isLowerCase();
    }

    @Test
    public void should_generate_random_lowercase_a_to_z() {
        assertThat(generator.generateRandomLowerCaseCharacter()).isBetween('a', 'z');
    }

    @Test
    public void should_generate_random_uppercase_characters_which_are_not_null() {
        assertThat(generator.generateRandomUpperCaseCharacter()).isNotNull();
    }

    @Test
    public void should_generate_random_uppercase_characters() {
        assertThat(generator.generateRandomUpperCaseCharacter()).isUpperCase();
    }

    @Test
    public void should_generate_random_uppercase_A_to_Z() {
        assertThat(generator.generateRandomUpperCaseCharacter()).isBetween('A', 'Z');
    }

    @Test
    public void should_generate_random_special_characters_which_are_not_null() {
        assertThat(generator.generateRandomSpecialCharacter()).isNotNull();
    }

    @Test
    public void should_generate_random_special() {
        assertThat(generator.generateRandomSpecialCharacter()).isBetween('!', '}');
    }
}