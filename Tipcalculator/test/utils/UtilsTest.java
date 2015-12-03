/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author animusanima
 */
public class UtilsTest 
{    
    // Bill amounts
    private final String TEN_EURO = "10";
    private final String ELEVEN_EURO_TWENTY_FIVE = "11.25";
    
    // Tip rates
    private final String TEN_PERCENT_TIP_RATE = "10";
    private final String FIFTEEN_PERCENT_TIP_RATE = "15";    
    
    // invalid values
    private final String ABC_AS_STRING = "ABC";
    
    public UtilsTest() {
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
    public void determineTipForWholeNumber() 
    {        
        double tip = CalculatorUtils.determineTip(TEN_EURO, FIFTEEN_PERCENT_TIP_RATE);
        assertThat(tip, is(1.5));
    }
    
    @Test
    public void determineTipForFloatNumber()
    {
        double tip = CalculatorUtils.determineTip(ELEVEN_EURO_TWENTY_FIVE, FIFTEEN_PERCENT_TIP_RATE);
        assertThat(tip, is(1.69));
    }
    
    @Test(expected = NumberFormatException.class)
    public void noneNumberThrowExceptionForBillAmount() 
    {
        CalculatorUtils.determineTip("abcd", FIFTEEN_PERCENT_TIP_RATE);
    }
    
    @Test(expected = NumberFormatException.class)
    public void noneNumberThrowExceptionForTipRate() 
    {
        CalculatorUtils.determineTip(TEN_EURO, "abcd");
    }
    
    @Test
    public void calculateTotalForWholeNumber()
    {
        double tip = CalculatorUtils.determineTip(TEN_EURO, FIFTEEN_PERCENT_TIP_RATE);
        double total = CalculatorUtils.calculateTotal(TEN_EURO, String.valueOf(tip));
        assertThat(total, is(11.50));
    }
    
    @Test
    public void calculateTotalForFloatNumber()
    {
        double tip = CalculatorUtils.determineTip(ELEVEN_EURO_TWENTY_FIVE, FIFTEEN_PERCENT_TIP_RATE);
        double total = CalculatorUtils.calculateTotal(ELEVEN_EURO_TWENTY_FIVE, String.valueOf(tip));
        assertThat(total, is(12.94));
    }    
    
    @Test
    public void parsingOfStringValueRepresentingAnInt()
    {
        int parsedInt = CalculatorUtils.convertTipRateToNumber(TEN_PERCENT_TIP_RATE);
        assertThat(parsedInt, is(10));
    }
    
    @Test(expected = NumberFormatException.class)
    public void parsingOfStringValueNonIntThrowsException()
    {
        CalculatorUtils.convertTipRateToNumber(ABC_AS_STRING);
    }
    
    @Test
    public void parsingOfStringValueRepresentingDouble()
    {
        double parsedDouble = CalculatorUtils.convertBillAmountToNumber(ELEVEN_EURO_TWENTY_FIVE);
        assertThat(parsedDouble, is(11.25));
    }
    
    @Test(expected = NumberFormatException.class)
    public void parsingOfStringValueNonDoubleThrowsException()
    {
        CalculatorUtils.convertBillAmountToNumber(ABC_AS_STRING);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void negativeValueForTipRateThrowsException()
    {
        int negativeTipRate = CalculatorUtils.convertTipRateToNumber(FIFTEEN_PERCENT_TIP_RATE) * -1;
        CalculatorUtils.determineTip(ELEVEN_EURO_TWENTY_FIVE, String.valueOf(negativeTipRate));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void negativeValueForBillAmountThrowsException()
    {
        double negativeDouble = CalculatorUtils.convertBillAmountToNumber(TEN_EURO) * -1;
        CalculatorUtils.determineTip(String.valueOf(negativeDouble), FIFTEEN_PERCENT_TIP_RATE);
    }
}