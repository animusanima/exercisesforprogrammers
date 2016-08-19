/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import interfaces.MathOperation;

/**
 *
 * @author hinterseber
 */
public class Multiplication implements MathOperation {

    @Override
    public int compute(int a, int b) {
        return a * b;
    }
    
}
