/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lafore.sort;

/**
 *
 * @author LocalUser
 */
public class MergeSort {

    private static int[] result;

    public static void main(String[] args) {

        result = new int[]{5, 2, 6, 1, 7, 3, 4, 0};
        display(result);
        sort();
        display(result);

    }

    private static void sort() {
        int[] tempArray = new int[result.length];
        mergeSort(tempArray, 0, result.length - 1);
    }

    private static void mergeSort(int[] tempArray, int lIdx, int hIdx) {
        if (lIdx >= hIdx) {
            return;
        } else {
            int mid = (lIdx + hIdx) / 2;
            
            mergeSort(tempArray, lIdx, mid);
            
            mergeSort(tempArray, mid + 1, hIdx);
            
            merge(tempArray, lIdx, mid + 1, hIdx);

        }
    }

    
    private static void merge(int[] tempArray, int lIdx, int mIdx, int hIdx) {

        int mid = mIdx - 1;
        int tIdx = 0;
        int nElements = hIdx - lIdx + 1;
        int lowerIndex = lIdx;
        
        while(lIdx <= mid && mIdx <= hIdx) {
            if(result[lIdx] < result[mIdx]) {
                tempArray[tIdx++] = result[lIdx++];
            } else {
                tempArray[tIdx++] = result[mIdx++];
            }
        }

        while (lIdx <= mid) {
            tempArray[tIdx++] = result[lIdx++];
        }

        while (mIdx <= hIdx) {
            tempArray[tIdx++] = result[mIdx++];
        }
        
        //display(tempArray);
        
        for(int i = 0; i < nElements; i++) {
            result[lowerIndex + i] = tempArray[i];
        }
        
        //clean Array
        /*for(int i = 0; i < tempArray.length; i++) {
            tempArray[i] = 0;
        }*/

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
