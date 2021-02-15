package services;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordServiceTest {
    IPasswordGeneratorService service;

    @BeforeMethod
    public void init() {
        service = new PasswordGeneratorService();
    }

    @Test(testName = "Testing general password is not null")
    public void should_generate_password_which_is_not_null() {
        assertThat(service.generatePassword()).isNotNull();
    }

    @Test(testName = "Testing general password is not empty")
    public void should_generate_password_which_is_not_empty() {
        service.setDesiredPasswordLength(1);
        assertThat(service.generatePassword()).isNotEmpty();
    }

    @Test(testName = "Password should be at least given length characters long")
    public void should_be_at_least_minimum_length_long_password() {
        service.setDesiredPasswordLength(1);
        String password = service.generatePassword();
        assertThat(password.length()).isEqualTo(service.getDesiredPasswordLength());
    }

    @Test(testName = "Generate each time a different password")
    public void should_generate_different_passwords() {
        service.setDesiredPasswordLength(50);
        service.setAmountOfNumbers(10);
        service.setNumberOfSpecialCharacters(10);

        String generatedPassword = service.generatePassword();
        String anotherGeneratedPassword = service.generatePassword();
        assertThat(generatedPassword).isNotEqualTo(anotherGeneratedPassword);

        System.out.println(generatedPassword);
        System.out.println(anotherGeneratedPassword);
    }
}