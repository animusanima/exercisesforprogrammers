package services;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class PasswordServiceTest {
    IPasswordGeneratorService service;

    @BeforeMethod
    public void init() {
        service = new PasswordGeneratorService(0,0,0);
    }

    @Test(testName = "Testing general password generation")
    public void should_print_generated_password() {
        assertThat(service.generatePassword()).isNotNull();
    }

    @Test(testName = "Password should be at least given length characters long")
    public void should_be_at_least_minimum_length_long_password() {
        fail("Not yet implemented");
    }

    @Test(testName = "Password contains special characters")
    public void should_contains_special_characters() {
        fail("Not yet implemented");
    }

    @Test(testName = "Password contains amount of special characters")
    public void should_contains_number_of_special_characters() {
        fail("Not yet implemented");
    }

    @Test(testName = "Password contains numbers")
    public void should_contain_numbers() {
        fail("Not yet implemented");
    }

    @Test(testName = "Password contains amount of numbers")
    public void should_contains_amount_of_numbers() {
        fail("Not yet implemented");
    }

    @Test(testName = "Generate each time a different password")
    public void should_generate_different_passwords() {
        fail("Not yet implemented");
    }
}