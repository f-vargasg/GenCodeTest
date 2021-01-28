/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fvgprinc.app.testgencode.test;

import com.fvgprinc.app.testgencode.bl.JavaCodeGenertor;
import com.fvgprinc.app.testgencode.dl.Conexion;

/**
 *
 * @author garfi
 */
public class TestApp {

    public static void main(String[] args) {

        if (Conexion.getInstance().isOpenConn()) {
            System.out.println("Conexion OK!!!!");
        } else {
            System.out.println("Conexion NO ok!!!");
        }

        String scrap = "Mensaje de prueba";
        String message = InitAllCaps(scrap);
        System.out.println("Message: " + message);
        
        JavaCodeGenertor jcg = new JavaCodeGenertor("mytest", "CL_PAMBPERFIL", "Inserta", "test");
        
        System.out.println("routineNameJavaStyle(): " + jcg.routineNameJavaStyle());
        System.out.println("javaStpParameters(): " + jcg.javaStpParameters());
        System.out.println("initStmtParams(): " + jcg.initStmtParams());
        
    }

    private static String InitAllCaps(String pStr) {
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
