/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import core.Calculator;
import data.MathOperationResult;
import interfaces.MathOperation;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author animusanima
 */
public class ArithmeticTests {
    
    private ArrayList<MathOperationResult> addition_results;
    private ArrayList<MathOperationResult> subtraction_results;
    
    private MathOperation addition;
    private MathOperation subtraction;
    
    public ArithmeticTests() 
    {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }
    
    @Before
    public void setUp() 
    {
        calculator = new Calculator();
        
        addition_results = new ArrayList<>();
        addition_results.add(new MathOperationResult(1, 1, 2));
        addition_results.add(new MathOperationResult(1, 2, 3));
        addition_results.add(new MathOperationResult(2, 3, 5));
        addition_results.add(new MathOperationResult(3, 5, 8));
        addition_results.add(new MathOperationResult(5, 8, 13));
        addition_results.add(new MathOperationResult(8, 13, 21));
        addition_results.add(new MathOperationResult(50, 50, 100));
        addition_results.add(new MathOperationResult(29, 29, 58));
        addition_results.add(new MathOperationResult(46, 13, 59));
        
        subtraction_results = new ArrayList<>();
        subtraction_results.add(new MathOperationResult(21, 13, 8));
        subtraction_results.add(new MathOperationResult(40, 20, 20));
        subtraction_results.add(new MathOperationResult(2, 1, 1));
        subtraction_results.add(new MathOperationResult(13, 13, 0));
        subtraction_results.add(new MathOperationResult(27, 28, -1));
        subtraction_results.add(new MathOperationResult(55, 45, 10));
        
        addition = (a, b) -> a + b;
        subtraction = (a, b) -> a -b;
    }
    
    @After
    public void tearDown() 
    {
    }
    
    @Test
    public void ComputationTests()
    {
        AdditionTests();
        SubtractionTests();
    }    
    
    private void AdditionTests()
    {       
        int computed;
        for (MathOperationResult result : addition_results) {            
            computed = calculator.operate(result.getFirstNumber(), result.getSecondNumber(), addition);
            assertThat(result.getExpected(), is(computed));
        }
    }    
    
    private void SubtractionTests() 
    {
        int computed;
        for (MathOperationResult result : subtraction_results) {
            computed = calculator.operate(result.getFirstNumber(), result.getSecondNumber(), subtraction);
            assertThat(result.getExpected(), is(computed));
        }
    }
    
    private Calculator calculator;
    
}