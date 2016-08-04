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
            System.out.print("{ " + dataId + ", " + data + " }");
        }
    }

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int dataId, T data) {
        Link newLink = new Link(dataId, data);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    //Testing linked list
    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList();
        ll.insertFirst(0, "first added");
        ll.insertFirst(1, "second added");
        ll.insertFirst(2, "third added");
        ll.insertFirst(3, "4th added");
        ll.insertFirst(4, "5th added");

        ll.displayList();

        while (!ll.isEmpty()) {
            System.out.print("Deleted: ");  
            ll.deleteFirst().displayLink();
            System.out.println("");
        }
        
        ll.displayList();

    }

}
