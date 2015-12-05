/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tipcalculator.TipCalculator;

/**
 *
 * @author animusanima
 */
public class TipCalculatorTest 
{
    private TipCalculator calculator;
    public TipCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        calculator = new TipCalculator();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void calculatorCanBeCreated()
    {        
        assertNotNull(calculator);
    }
    
    @Test
    public void hasParametrizedConstructor()
    {
        calculator = new TipCalculator(1.1, 1.2);        
    }
    
    @Test
    public void canUpdateBillAmount()
    {
        calculator.updateBillAmount(10.0);
        assertThat(calculator.currentBillAmount(), is(10.0));
    }
    
    @Test
    public void canUpdateTipRate()
    {
        calculator.updateTipRate(15.0);
        assertThat(calculator.currentTipRate(), is(15.0));
    }
    
}