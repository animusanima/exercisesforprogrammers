package tests;

import counter.CharacterCounter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import testInput.TestInputConstants;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author animusanima
 */
public class CharacterCounterTest 
{
    public CharacterCounterTest() {
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
    
    @Test
    public void whenEmptyStringIsGivenReturnZero()
    {
        assertThatInputIsOfExpectedLength(TestInputConstants.EMPTY_INPUT, 
                TestInputConstants.EMPTY_INPUT.length());
    }    
    
    @Test
    public void whenNullIsGivenReturnZero()
    {
        assertThatInputIsOfExpectedLength(null, 0);
    }    
    
    @Test
    public void whenSingleCharInputIsGivenReturnOne()
    {
        assertThatInputIsOfExpectedLength(TestInputConstants.SINGLE_CHAR_INPUT, 
                TestInputConstants.SINGLE_CHAR_INPUT.length());
    }    
    
    @Test
    public void whenTwoCharInputIsGivenReturnTwo()
    {
        assertThatInputIsOfExpectedLength("AB", "AB".length());
    }       
    
    @Test
    public void returnNumberOfCharactersOfAnyLengthString()
    {
        StringBuilder input = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            input.append(String.valueOf(i));
            assertThatInputIsOfExpectedLength(input.toString(), i);
        }
    }

    private void assertThatInputIsOfExpectedLength(String input, int expectedLength) {
        int result = CharacterCounter.lengthOf(input);
        assertThat(result, is(expectedLength));
    }
}