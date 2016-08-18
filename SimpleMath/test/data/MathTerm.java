/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author animusanima
 */
public class MathTerm 
{
    private final int number_one;
    private final int number_two;
    private final int expected;
    
    public MathTerm(int a, int b, int expected) {
        this.number_one = a;
        this.number_two = b;
        this.expected = expected;
    }
    
    public int getFirstNumber()
    {
        return number_one;
    }
    
    public int getSecondNumber()
    {
        return number_two;
    }     
    
    public int getExpected() 
    {
        return expected;
    }    
}