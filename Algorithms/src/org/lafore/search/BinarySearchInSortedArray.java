/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lafore.search;

/**
 *
 * @author LocalUser
 */
public class BinarySearchInSortedArray {
    
    public static void main(String[] args) {
        BinarySearchInSortedArray bs = new BinarySearchInSortedArray();
        int[] array = {1, 2, 5, 18, 22, 56, 78, 102, 112, 336, 556, 784};
        int key = 556;
        System.out.println(bs.find(array, key));
    }

    public int find(int[] a, int searchKey) {
        int nElems = a.length;
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;              // Элемент найден
            } else if (lowerBound > upperBound) {
                return nElems;             // Элемент не найден
            } else           // Деление диапазона         
            {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1; // В верхней половине         
                } else {
                    upperBound = curIn - 1; // В нижней половине         
                }
            }
        }
    }
}
