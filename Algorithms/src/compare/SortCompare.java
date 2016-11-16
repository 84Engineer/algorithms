/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compare;

/**
 *
 * @author oslysenko
 */
public class SortCompare {

    private static int[] result;

    public static void main(String[] args) {

        int size = 1_0_000;
        int tempArr[] = new int[size];

        for (int i = 0; i < size; i++) {
            tempArr[i] = (int) (Math.random() * 999);
        }
        //Comparing bubble sort and Shell sort
        result = tempArr;
        long start = System.currentTimeMillis();
        shellSort();
        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("Shell sort time: " + duration);

        result = tempArr;

        start = System.currentTimeMillis();
        bubbleSort();
        end = System.currentTimeMillis();
        duration = end - start;

        System.out.println("Bubble sort time: " + duration);

        result = tempArr;

        start = System.currentTimeMillis();
        insertionSort();
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Insertion sort time: " + duration);

        result = tempArr;

        start = System.currentTimeMillis();
        selectionSort();
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Selection sort time: " + duration);

        result = tempArr;

        start = System.currentTimeMillis();
        mergeSort();
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Merge sort time: " + duration);

        result = tempArr;

        start = System.currentTimeMillis();
        quickSort();
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Quick sort time: " + duration);

    }

    public static void shellSort() {

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

    public static void bubbleSort() {

        for (int out = result.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (result[in] > result[in + 1]) {
                    int temp = result[in];
                    result[in] = result[in + 1];
                    result[in + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort() {

        for (int out = 1; out < result.length; out++) {

            int temp = result[out];
            int in = out;

            while (in > 0 && result[in - 1] >= temp) {
                result[in] = result[in - 1];
                in--;
            }
            result[in] = temp;
        }
    }

    public static void selectionSort() {
        for (int out = 0; out < result.length - 1; out++) {

            int min = out;

            for (int in = out + 1; in < result.length; in++) {
                if (result[min] > result[in]) {
                    min = in;
                }
            }
            if (min != out) {
                int temp = result[out];
                result[out] = result[min];
                result[min] = temp;
            }
        }
    }

    private static void mergeSort() {
        int[] tempArray = new int[result.length];
        mrgSort(tempArray, 0, result.length - 1);
    }

    private static void mrgSort(int[] tempArray, int lIdx, int hIdx) {
        if (lIdx >= hIdx) {
            return;
        } else {
            int mid = (lIdx + hIdx) / 2;

            mrgSort(tempArray, lIdx, mid);

            mrgSort(tempArray, mid + 1, hIdx);

            merge(tempArray, lIdx, mid + 1, hIdx);

        }
    }

    private static void merge(int[] tempArray, int lIdx, int mIdx, int hIdx) {

        int mid = mIdx - 1;
        int tIdx = 0;
        int nElements = hIdx - lIdx + 1;
        int lowerIndex = lIdx;

        while (lIdx <= mid && mIdx <= hIdx) {
            if (result[lIdx] < result[mIdx]) {
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

        for (int i = 0; i < nElements; i++) {
            result[lowerIndex + i] = tempArray[i];
        }

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

}
