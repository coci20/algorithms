/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.adtsamples;

import java.util.EmptyStackException;

/**
 *
 * @author prasannjitk
 */
public class MyStack<T> {
    private class StackNode<T>{
        private T data;
        private StackNode<T> next;
        
        public StackNode(T item) {
            this.data = item;
        }
    }
    
    private StackNode<T> top;
    
    public void push(T item) {
        StackNode<T> s = new StackNode<T>(item);
        s.data = item;
        s.next = top;
        top = s;
    }
    
    public T pop() {
        if (top != null) {
            StackNode<T> s = top;
            top = top.next;
            T value = s.data;
            s = null;
            return value;
        }
        else
            throw new EmptyStackException();
    }
    
    public T peek() {
        if (top != null) {
            return top.data;
        }
        else
            throw new EmptyStackException();
    }
    
    public boolean isEmpty() {
        return (top == null);
    }
    
}
