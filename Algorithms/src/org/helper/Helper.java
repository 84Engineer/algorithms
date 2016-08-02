/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.helper;

import java.util.Random;

/**
 *
 * @author oslysenko
 */
public class Helper {

    public static String display(int[] array) {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        return sb.toString();
    }
    
    public static int[] generateIntArray(int min, int max, int size) {
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            Random random = new Random();
            result[i] = random.nextInt((max - min) + 1) + min;
        }
        return result;
    }

}
