/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lafore.sort;

import org.helper.Helper;


/**
 *
 * @author oslysenko
 */
public class SelectionSort {
    
    
    public static void main(String[] args) {
        int[] array = Helper.generateIntArray(0, 1000, 20);
        System.out.println("Unsorted: " + Helper.display(array));
        SelectionSort ss = new SelectionSort();
        ss.sort(array);
        System.out.println("Sorted: " + Helper.display(array));
    }
    
    /*
    *O(N^2) for search
    *O(N) for swaps
    *O(N^2) in common
    *performance is better than in bubble sort because objects do not have to be phisically swapped as often as in bubble sort
    */
    public int[] sort(int[] array) {
        for(int out = 0; out < array.length - 1; out++) {
            
            int min = out;
            
            for(int in = out + 1; in < array.length; in ++) {
                if(array[min] > array[in]) {
                    min = in;
                }
            }
            if(min != out) {
                int temp = array[out];
                array[out] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }
    
}
