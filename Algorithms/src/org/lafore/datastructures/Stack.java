/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lafore.datastructures;

/**
 *
 * @author oslysenko
 * @param <T>
 */
public class Stack<T> {
    //Implementation
    private int top = -1;
    private final Object[] stackArray;

    public Stack(int size) {
        stackArray = new Object[size];
    }

    public void push(T element) {
        if (top < stackArray.length - 1) {
            stackArray[++top] = element;
        }
    }

    public T pop() {
        if (top >= 0) {
            return (T) stackArray[top--];
        }
        return null;
    }
    
    public T peek() {
        if (top >= 0) {
            return (T) stackArray[top];
        }
        return null;
    }
    //End of implementation
    
    //Testing Stack
    public static void main(String[] args) {
        //1) String stack
        Stack<String> ss = new Stack(10);
        ss.push("stack");
        ss.push("from");
        ss.push("String");
        ss.push("am");
        ss.push("I");
        
        while(ss.peek() != null) {
            System.out.println(ss.pop());
        }
        
        System.out.println("Stack is empty ss.pop() = " + ss.pop());
        //2) Integer stack
        Stack<Integer> si = new Stack(10);
        
        for(int i = 0; i <= 10; i++) {
            si.push(i);
        }
        
        for(int i = 0; i <= 10; i++) {
            System.out.println(si.pop());
        }
        
        System.out.println("Stack is empty si.pop() = " + si.pop());
        
        //3) Reverse word
        Stack<Character> sc = new Stack(100);
        String words = "Some words that should be reverted.";
        System.out.println("Input: " + words);
        for(char c : words.toCharArray()) {
            sc.push(c);
        }
        
        StringBuilder result = new StringBuilder();
        
        while(sc.peek() != null) {
            result.append(sc.pop());
        }
        
        System.out.println("Result is: " + result);
        
        //4) Brackets checker
        String bracketsString = "asdf(dr(gd)d)rg";  //"for(me{and[you]it}doesn't)matter";
        Stack<Character> bracketsStack = new Stack(100);
        
        for(char c : bracketsString.toCharArray()) {
            switch(c) {
                case '(':
                case '[':
                case '{':
                    bracketsStack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if(bracketsStack.peek() != null) {
                        char ch = bracketsStack.pop();
                        if(c == ')' && ch != '(' || c == ']' && ch != '[' || c == '}' && ch != '{') {
                            System.out.println("Error " + ch);
                            return;
                        }
                    } else {
                        System.out.println("Error not enough elements");
                        return;
                    }
                    break;
                default:
                    break;
            }
        }
        if(bracketsStack.peek() != null) {
            System.out.println("Error: missing right delimiter.");
            return;
        }
        System.out.println("String processed, no errors occured.");
    }
    
}
