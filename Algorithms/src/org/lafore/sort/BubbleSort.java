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
public class BubbleSort {

    public static void main(String[] args) {
        int[] unsorted = {12, 34, 23, 54, 7, 1, 43, 76, 563, 66, 76, 34, 121, 878, 3453, 788, 345, 46, 8, 2, 5};
        System.out.println("Unsorted: " + display(unsorted));
        BubbleSort bs = new BubbleSort();
        bs.sort(unsorted);
        System.out.println("Sorted: " + display(unsorted));
    }
    //O(N^2)
    public int[] sort(int[] array) {

        for (int out = array.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    int temp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                }
            }
        }
        return array;
    }

    private static String display(int[] array) {
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

}
