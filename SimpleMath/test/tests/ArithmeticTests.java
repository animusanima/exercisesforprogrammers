/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import core.Calculator;
import data.MathTerm;
import interfaces.MathOperation;
import java.util.ArrayList;
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
    
    private final ArrayList<MathTerm> addition_results;
    private final ArrayList<MathTerm> subtraction_results;
    private final ArrayList<MathTerm> multiplication_results;
    private final ArrayList<MathTerm> division_results;
    
    private final MathOperation addition;
    private final MathOperation subtraction;
    private final MathOperation multiplication;
    private final MathOperation division;
    
    public ArithmeticTests() 
    {
        addition_results = new ArrayList<>();
        addition_results.add(new MathTerm(1, 1, 2));
        addition_results.add(new MathTerm(1, 2, 3));
        addition_results.add(new MathTerm(2, 3, 5));
        addition_results.add(new MathTerm(3, 5, 8));
        addition_results.add(new MathTerm(5, 8, 13));
        addition_results.add(new MathTerm(8, 13, 21));
        addition_results.add(new MathTerm(50, 50, 100));
        addition_results.add(new MathTerm(29, 29, 58));
        addition_results.add(new MathTerm(46, 13, 59));
        
        subtraction_results = new ArrayList<>();
        subtraction_results.add(new MathTerm(21, 13, 8));
        subtraction_results.add(new MathTerm(40, 20, 20));
        subtraction_results.add(new MathTerm(2, 1, 1));
        subtraction_results.add(new MathTerm(13, 13, 0));
        subtraction_results.add(new MathTerm(27, 28, -1));
        subtraction_results.add(new MathTerm(55, 45, 10));
        
        multiplication_results = new ArrayList<>();
        multiplication_results.add(new MathTerm(1, 1, 1));
        multiplication_results.add(new MathTerm(2, 2, 4));
        multiplication_results.add(new MathTerm(11, 11, 121));
        multiplication_results.add(new MathTerm(55, 3, 165));
        multiplication_results.add(new MathTerm(8, 7, 56));
        multiplication_results.add(new MathTerm(1, 0, 0));
        
        division_results = new ArrayList<>();
        division_results.add(new MathTerm(1, 1, 1));
        division_results.add(new MathTerm(2, 2, 1));
        division_results.add(new MathTerm(20, 5, 4));
        division_results.add(new MathTerm(55, 11, 5));
        division_results.add(new MathTerm(56, 7, 8));
        division_results.add(new MathTerm(121, 11, 11));
        division_results.add(new MathTerm(Integer.MAX_VALUE, Integer.MAX_VALUE, 1));                
        division_results.add(new MathTerm(Integer.MIN_VALUE, Integer.MIN_VALUE, 1));
        
        addition = (a, b) -> a + b;
        subtraction = (a, b) -> a - b;
        multiplication = (a, b) -> a * b;
        division = (a, b) -> (a / b);
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
    }
    
    @After
    public void tearDown() 
    {
    }   
    
    @Test
    public void Additions()
    {       
        Test_MathematicOperation(addition_results, addition);
    }    
    
    @Test
    public void Subtractions() 
    {
        Test_MathematicOperation(subtraction_results, subtraction);
    }
    
    @Test
    public void Multiplications()
    {
        Test_MathematicOperation(multiplication_results, multiplication);
    }   
    
    @Test
    public void Divisions()
    {
        Test_MathematicOperation(division_results, division);       
    }
    
    private void Test_MathematicOperation(ArrayList<MathTerm> terms, MathOperation operation)
    {
        int computed;
        for (MathTerm term : terms) {
            computed = calculator.compute(term.getFirstNumber(), term.getSecondNumber(), operation);
            assertThat(term.getExpected(), is(computed));
        }
    }
    
    @Test(expected = ArithmeticException.class)
    public void DivisionByZero_RaisesArithmeticException() {
        Number result = calculator.compute(1, 0, division);
        assertThat(result, is(0));
    }    
    
    private Calculator calculator;
}