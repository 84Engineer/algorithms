/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lafore.datastructures;

/**
 *
 * @author oslysenko
 */
public class Queue<T> {

    private Object[] elements;
    private int front = 0;
    private int rear = -1;
    private int items = 0;

    public Queue(int size) {
        elements = new Object[size];
    }

    public void insert(T element) {
        if (items < elements.length) {
            if (rear == elements.length - 1) {
                rear = - 1;
            }
            elements[++rear] = element;
            items++;
        }
    }

    public T remove() {
        if (items > 0) {
            T temp = (T) elements[front++];
            if (front == elements.length) {
                front = 0;
            }
            items--;
            return temp;
        }
        return null;
    }

    public T peek() {
        if (items > 0) {
            return (T) elements[front];
        }
        return null;
    }
    
    
    //Testing queue
    public static void main(String[] args) {
        Queue<Integer> io = new Queue(5);
        
        for(int i = 0; i <= 5; i++) {
            System.out.println("Inserting " + i);
            io.insert(i);
        }
        
        io.remove();
        io.remove();
        io.remove();
        
        for(int i = 0; i <= 5; i++) {
            System.out.println("Inserting " + i);
            io.insert(i);
        }
        
        
        while(io.peek() != null) {
            System.out.println("Removing " + io.remove());
        }
                
    }

}
