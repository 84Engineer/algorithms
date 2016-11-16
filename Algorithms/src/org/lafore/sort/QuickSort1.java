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
public class QuickSort1 {

    private static int[] result;

    public static void main(String[] args) {
        
        result = new int[]{5, 2, 14, 6, 1, 7, 13, 3, 4, 0, 11, 9, 8, 10, 15, 12};
        display(result);
        quickSort();
        display(result);

    }
    
    private static void quickSort() {
        performSort(0, result.length - 1);
    }

    private static void performSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            int pivot = result[right];
            int partition = partition(left, right, pivot);
            performSort(left, partition - 1);
            performSort(partition + 1, right);
        }
    }

    private static int partition(int left, int right, int pivot) {
        int leftIdx = left - 1;
        int rightIdx = right;

        while (true) {
            while (result[++leftIdx] < pivot) {
            }
            while (rightIdx > 0 && result[--rightIdx] > pivot) {
            }
            if (leftIdx >= rightIdx) {
                break;
            } else {
                swap(leftIdx, rightIdx);
            }
        }
        swap(leftIdx, right);
        return leftIdx;
    }

    private static void swap(int left, int right) {
        int temp = result[left];
        result[left] = result[right];
        result[right] = temp;
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
