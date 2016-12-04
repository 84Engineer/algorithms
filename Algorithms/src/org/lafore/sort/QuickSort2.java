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
public class QuickSort2 {

    private static int[] result;

    public static void main(String[] args) {

        int max = 10_000_000;
        result = new int[max];

        for (int i = 0; i < max; i++) {
            result[i] = (int) (Math.random() * 999);
        }

        //result = new int[]{3, 5, 1, 2, 4, 7, 8, 0, 6, 9};
        //display();
        long start = System.currentTimeMillis();
        quickSort();
        long end = System.currentTimeMillis();
        System.out.println("Sorting of " + max + " elements took " + (end - start) + " mills");
        //display();

    }

    private static void quickSort() {
        performSort(0, result.length - 1);
    }

    public static void performSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3) {
            manualSort(left, right);
        } else {
            int median = median(left, right);
            int pivot = partition(left, right, median);
            performSort(left, pivot - 1);
            performSort(pivot + 1, right);
            //display(left, right);
        }
    }

    private static int partition(int left, int right, int pivot) {
        int leftIdx = left;
        int rightIdx = right - 1;

        while (true) {
            while (result[++leftIdx] < pivot) ;
            while (result[--rightIdx] > pivot) ;

            if (leftIdx >= rightIdx) {
                break;
            } else {
                swap(leftIdx, rightIdx);
            }
        }
        swap(leftIdx, right - 1);
        return leftIdx;
    }

    private static int median(int left, int right) {
        int center = (left + right) / 2;

        if (result[left] > result[center]) {
            swap(left, center);
        }

        if (result[left] > result[right]) {
            swap(left, right);
        }

        if (result[center] > result[right]) {
            swap(center, right);
        }

        swap(center, right - 1);
        return result[right - 1];
    }

    private static void manualSort(int left, int right) {
        int size = right - left + 1;

        if (size <= 1) {
            return;
        } else if (size == 2) {
            if (result[left] > result[right]) {
                swap(left, right);
            }
        } else if (size == 3) {
            if (result[left] > result[right - 1]) {
                swap(left, right - 1);
            }
            if (result[left] > result[right]) {
                swap(left, right);
            }
            if (result[right - 1] > result[right]) {
                swap(right - 1, right);
            }
        }
    }

    public static void swap(int leftIdx, int rightIdx) {
        int temp = result[leftIdx];
        result[leftIdx] = result[rightIdx];
        result[rightIdx] = temp;
    }

    private static void display() {
        for (int e : result) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    private static void display(int left, int right) {
        for (; left <= right; left++) {
            System.out.print(result[left] + " ");
        }
        System.out.println();
    }

}
