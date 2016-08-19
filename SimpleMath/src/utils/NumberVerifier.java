/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author hinterseber
 */
public class NumberVerifier {

    private static final String NUMBERS_ONLY_PATTERN = "[0-9]+";

    public static boolean hasNumbersOnly(String value) {
        return value.matches(NUMBERS_ONLY_PATTERN);
    }
}
