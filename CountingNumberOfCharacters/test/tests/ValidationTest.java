package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import testInput.TestInputConstants;
import validator.InputValidator;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author animusanima
 */
public class ValidationTest 
{    
    public ValidationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }   
    
    
    @Test(expected = IllegalArgumentException.class)
    public void whenInputIsEmptyStateUserToEnterSomething()
    {
        InputValidator.validate(TestInputConstants.EMPTY_INPUT);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ifNullInputIsGivenThrowException()
    {
        InputValidator.validate(null);
    }    
    
    @Test
    public void whenNonEmptyStringIsGivenValidationIsSuccessful()
    {
        boolean result = InputValidator.validate(TestInputConstants.SINGLE_CHAR_INPUT);
        assertThat(result, is(true));
    }
    
    @Test
    public void canIdentifyNullOrEmptyStrings()
    {
        boolean result = InputValidator.isNullOrEmpty(null);
        assertThat(result, is(true));
        
        result = InputValidator.isNullOrEmpty(TestInputConstants.EMPTY_INPUT);
        assertThat(result, is(true));
    }
    
}