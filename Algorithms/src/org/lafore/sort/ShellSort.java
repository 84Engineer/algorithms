/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lafore.sort;

/**
 *
 * @author oslysenko
 */
public class ShellSort {

    private static int[] result;

    public static void main(String[] args) {

        result = new int[]{3, 4, 8, 1, 2, 6, 5, 7, 0, 9};

        display(result);
        sort();
        display(result);

    }

    public static void sort() {

        int h = 1;

        while (h <= result.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {

            for (int outer = h; outer < result.length; outer++) {

                int temp = result[outer];
                int inner = outer;

                while (inner > h - 1 && result[inner - h] > temp) {
                    result[inner] = result[inner - h];
                    inner -= h;
                }
                result[inner] = temp;
            }
            h = (h - 1) / 3;
        }

    }

    private static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }

}
