package services;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class PrinterServiceTest {

    private IPrinterService service;

    @BeforeMethod
    public void init() {
        service = new PrinterService();
    }

    @Test(testName = "Ask user to enter minimum length")
    public void should_prompt_user_for_minimum_length() {
        assertThat(service.askForMinimumLength()).isEqualTo("What is the minimum length? ");
    }

    @Test(testName = "Ask user to enter amount of special characters")
    public void should_prompt_user_for_amount_of_special_character() {
        assertThat(service.askForAmountOfSpecialCharacters()).isEqualTo("How many special characters? ");
    }

    @Test(testName = "Ask user to enter amount of number")
    public void should_prompt_user_for_amount_of_numbers() {
        assertThat(service.askForAmountOfNumbers()).isEqualTo("How many numbers? ");
    }

}