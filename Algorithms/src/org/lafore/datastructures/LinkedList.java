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
public class LinkedList<T> {
    
    private Link first;

    private class Link {

        public int dataId;
        public T data;
        public Link next;

        public Link(int dataId, T data) {
            this.dataId = dataId;
            this.data = data;
        }
        
        public void displayLink() {
            System.out.println("{ " + dataId + ", " + data + " }");
        }
    }
    
    

}
