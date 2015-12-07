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
public class ConversionUtilsTest 
{
    // convertables
    private static final String TEN_EURO = "10.0";
    
    // non-convertables
    private static final String NONE_NUMBER = "ABCD";    
    
    public ConversionUtilsTest() {
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
    public void canConvertStringToDouble()
    {
        double result = ConversionUtils.convertToDouble(TEN_EURO);
        assertThat(result, is(10.0));
    }
    
    @Test(expected = NumberFormatException.class)
    public void noneNumberStringThrowsNumberFormatException()
    {
        double result = ConversionUtils.convertToDouble(NONE_NUMBER);
    }

}