/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greeters;

/**
 *
 * @author animusanima
 */
public final class Greeter 
{
    public static String greet(String name)
    {
        return String.format("Hello %s, nice to meet you.", name);
    }
}