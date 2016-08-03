/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lafore.datastructures;

/**
 *
 * @author LocalUser
 * @param <T>
 */
public class PriorityQueue<T extends Comparable> {

    private final Comparable[] queueData;
    private int nElements = 0;

    public PriorityQueue(int size) {
        queueData = new Comparable[size];
    }

    public void insert(T element) {
        if (nElements == 0) {
            queueData[nElements++] = element;
        } else {
            int i;
            for (i = nElements - 1; i >= 0; i--) {
                if (element.compareTo(queueData[i]) > 0) {
                    queueData[i + 1] = queueData[i];
                } else {
                    break;
                }
            }
            queueData[i + 1] = element;
            nElements++;
        }
    }

    public T remove() {
        return (T) queueData[--nElements];
    }

    public T peek() {
        return (T) queueData[nElements - 1];
    }

    public boolean isEmpty() {
        return nElements == 0;
    }

    public boolean isFull() {
        return nElements == queueData.length;
    }

    //Testing PQ
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue(10);
        pq.insert(10);
        pq.insert(50);
        pq.insert(80);
        pq.insert(5);
        pq.insert(1);
        pq.insert(3);

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

}
