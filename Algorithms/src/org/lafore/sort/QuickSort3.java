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
public class QuickSort3 {

    private static int[] result;

    public static void main(String[] args) {

        int max = 10_000_000;
        result = new int[max];

        for (int i = 0; i < max; i++) {
            result[i] = (int) (Math.random() * 999);
        }

        // = new int[]{3, 5, 1, 2, 4, 7, 8, 0, 6, 9};
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
        if (size <= 6) {
            insertionSort(left, right);
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

    private static void insertionSort(int left, int right) {
        int in, out;

        for (out = left; out <= right; out++) {
            int temp = result[out];
            in = out;

            while (in > left && result[in - 1] >= temp) {
                result[in] = result[in - 1];
                --in;
            }
            result[in] = temp;
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
