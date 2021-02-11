package services;

import enumerations.PasswordStrength;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PasswordServiceTest {

    private IPasswordStrengthIndicatorService passwordStrengthIndicatorService;

    @BeforeMethod
    public void init() {
        passwordStrengthIndicatorService = new PasswordStrengthIndicatorService();
    }

    @Test(testName = "Expecting illegal argument exception for null value")
    public void should_throw_illegal_argument_exception_for_null_value() {
        assertThatIllegalArgumentException().isThrownBy(() -> passwordStrengthIndicatorService.measurePasswordStrength(null));
    }

    @Test(testName = "Expecting illegal argument exception for empty value")
    public void should_throw_illegal_argument_exception_for_empty_value() {
        assertThatIllegalArgumentException().isThrownBy(() -> passwordStrengthIndicatorService.measurePasswordStrength(""));
    }

    @Test(testName = "Testing for exact illegal argument exception test for null value")
    public void should_state_message_of_illegal_argument_exception_for_null_value() {
        Throwable t = catchThrowable(() -> passwordStrengthIndicatorService.measurePasswordStrength(null));
        final String NULL_PASSWORD_EXCEPTION_MESSAGE = "Password strength can not be measured for null value";
        assertThat(t.getMessage()).isEqualTo(NULL_PASSWORD_EXCEPTION_MESSAGE);
    }

    @Test(testName = "Testing for exact illegal argument exception test for empty value")
    public void should_state_message_of_illegal_argument_exception_for_empty_value() {
        Throwable t = catchThrowable(() -> passwordStrengthIndicatorService.measurePasswordStrength(""));
        final String EMPTY_PASSWORD_EXCEPTION_MESSAGE = "Password strength can not be measured for empty value";
        assertThat(t.getMessage()).isEqualTo(EMPTY_PASSWORD_EXCEPTION_MESSAGE);
    }

    @Test(testName = "Testing identification of very weak password")
    public void should_identify_very_weak_password() {
        final String VERY_WEAK_PASSWORD = "1234";
        assertThat(passwordStrengthIndicatorService.measurePasswordStrength(VERY_WEAK_PASSWORD)).isEqualTo(PasswordStrength.VERY_WEAK);
    }

    @Test(testName = "Testing identification of very weak password min value")
    public void should_identify_very_weak_password_with_min_value() {
        final String VERY_WEAK_PASSWORD_MIN_VALUE = "0";
        assertThat(passwordStrengthIndicatorService.measurePasswordStrength(VERY_WEAK_PASSWORD_MIN_VALUE)).isEqualTo(PasswordStrength.VERY_WEAK);
    }

    @Test(testName = "Testing identification of very weak password min length")
    public void should_identify_very_weak_password_with_min_length() {
        final String VERY_WEAK_PASSWORD_MIN_LENGTH = "1";
        assertThat(passwordStrengthIndicatorService.measurePasswordStrength(VERY_WEAK_PASSWORD_MIN_LENGTH)).isEqualTo(PasswordStrength.VERY_WEAK);
    }

    @Test(testName = "Testing identification of very weak password length edge case")
    public void should_identify_very_weak_password_with_length_edge_case() {
        final String VERY_WEAK_PASSWORD_LENGTH_EDGE_CASE = "123456";
        assertThat(passwordStrengthIndicatorService.measurePasswordStrength(VERY_WEAK_PASSWORD_LENGTH_EDGE_CASE)).isEqualTo(PasswordStrength.VERY_WEAK);
    }

    @Test(testName = "Testing identification of weak password")
    public void should_identify_weak_password() {
        final String WEAK_PASSWORD = "abcd";
        assertThat(passwordStrengthIndicatorService.measurePasswordStrength(WEAK_PASSWORD)).isEqualTo(PasswordStrength.WEAK);
    }

    @Test(testName = "Testing identification of weak password min value")
    public void should_identify_weak_password_with_min_value() {
        final String WEAK_PASSWORD_MIN_VALUE = "a";
        assertThat(passwordStrengthIndicatorService.measurePasswordStrength(WEAK_PASSWORD_MIN_VALUE)).isEqualTo(PasswordStrength.WEAK);
    }

    @Test(testName = "Testing identification of weak password length edge case")
    public void should_identify_weak_password_with_length_edge_case() {
        final String WEAK_PASSWORD_LENGTH_EDGE_CASE = "abcdef";
        assertThat(passwordStrengthIndicatorService.measurePasswordStrength(WEAK_PASSWORD_LENGTH_EDGE_CASE)).isEqualTo(PasswordStrength.WEAK);
    }

    @Test(testName = "Testing identification of strong password with numbers and letters")
    public void should_identify_strong_password_with_length_edge_case() {
        final String STRONG_PASSWORD = "abc123xy";
        assertThat(passwordStrengthIndicatorService.measurePasswordStrength(STRONG_PASSWORD)).isEqualTo(PasswordStrength.STRONG);
    }

    @Test(testName = "Testing identification of very strong password with numbers and letters and special characters")
    public void should_identify_very_strong_password() {
        final String VERY_STRONG_PASSWORD = "@bc123xy!";
        assertThat(passwordStrengthIndicatorService.measurePasswordStrength(VERY_STRONG_PASSWORD)).isEqualTo(PasswordStrength.VERY_STRONG);
    }

}