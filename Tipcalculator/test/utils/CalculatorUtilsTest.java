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
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author animusanima
 */
public class CalculatorUtilsTest 
{           
    private static final double FIFTEEN_PERCENT_TIP_RATE = 15.0;
    private static final double TEN_EURO_BILL = 10.0;
    
    public CalculatorUtilsTest() {
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
    public void canCalculateTip()
    {
        double tip = CalculatorUtils.calculateTip(TEN_EURO_BILL, FIFTEEN_PERCENT_TIP_RATE);
        assertThat(tip, is(1.50));
    }
    
    @Test
    public void canCalculateTotal()
    {
        double total = CalculatorUtils.calculateTotal(TEN_EURO_BILL, 1.50);
        assertThat(total, is(11.50));
    }
}