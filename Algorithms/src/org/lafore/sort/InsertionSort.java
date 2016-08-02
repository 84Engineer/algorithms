/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lafore.sort;

import org.helper.Helper;

/**
 *
 * @author LocalUser
 */
public class InsertionSort {
    

    public static void main(String[] args) {
        int[] array = Helper.generateIntArray(0, 100, 10);
        System.out.println("Unsorted: " + Helper.display(array));
        InsertionSort is = new InsertionSort();
        is.sort(array);
        System.out.println("Sorted: " + Helper.display(array));
    }

    /*
    *Speed is O(N^2) 
    *The most efficient algorithm with all of speed O(N^2)
    *working faster when data is paritally sorted
    *Copying is faster than swap, so it's working faster than bubble and selection sort.
    */
    public int[] sort(int[] array) {
        
        for(int out = 1; out < array.length; out++) {
            
            int temp = array[out];
            int in = out;
            
            while(in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                in--;
            }
            array[in] = temp;
        }
        return array;
    }
    
}
