/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fvgprinc.app.testgencode.utils;

/**
 *
 * @author garfi
 */
public class StringUtils {

    public static String InitAllCaps(String pStr) {
        // String message = "Ejecutar_rutina";
        // stores each characters to a char array
        char[] charArray = pStr.toCharArray();
        boolean foundSpace = true;
        for (int i = 0; i < charArray.length; i++) {

            // if the array element is a letter
            if (Character.isLetter(charArray[i])) {

                // check space is present before the letter
                if (foundSpace) {

                    // change the letter into uppercase
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            } else {
                // if the new character is not character
                foundSpace = true;
            }
        }
        // convert the char array to the string
        pStr = String.valueOf(charArray);
        return pStr;
    }
}
