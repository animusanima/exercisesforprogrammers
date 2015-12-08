/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import greeters.Greeter;
import java.util.Scanner;

/**
 *
 * @author animusanima
 */
public final class SayingHello 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.print("What is your name? ");
        System.out.println(Greeter.greet(new Scanner(System.in).nextLine()));
    }
    
}