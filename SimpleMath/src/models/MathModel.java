/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hinterseber
 */
public class MathModel 
{
    private int variable_a, variable_b;
    
    public MathModel(int a, int b) {        
        variable_a = a;
        variable_b = b;
    }
    
    public void updateVariables(int a, int b) {
        variable_a = a;
        variable_b = b;
    }
    
    public int getVariableA() {
        return variable_a;
    }
    
        public int getVariableB() {
        return variable_b;
    }
}