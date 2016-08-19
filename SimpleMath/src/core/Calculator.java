/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import interfaces.MathOperation;

/**
 *
 * @author animusanima
 */
public class Calculator
{    
    public int compute(int a, int b, MathOperation operation) {
        return operation.compute(a, b);
    }
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public int divide(int a, int b) {
        return (b > 0 ? a / b : 0);
    }
}