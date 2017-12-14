/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.adtsamples;

/**
 *
 * @author prasannjitk
 */
public class MyQueue<T> {

    private static class EmptyQueueException extends Exception {

        public EmptyQueueException() {
            System.err.println("Queue is empty");
        }
    }
    private class MyQueueNode<T> {
        private T data;
        private MyQueueNode<T> next;
    
    
        public MyQueueNode(T item){
            this.data = item;
        }
    }
    
    private MyQueueNode<T> front;
    private MyQueueNode<T> rear;
    
    public void add(T item){
        //add to the rear of the Q
        MyQueueNode<T> n = new MyQueueNode(item);
        if (rear != null) {
            rear.next = n;
            rear = n;
        }
        if (front == null)      //no elements were present
            front = rear;       //front and rear point to the first
    }
    
    public T remove() throws EmptyQueueException{
        if (front == null)
            throw new EmptyQueueException();
        T val = front.data;
        front = front.next;
        if (front == null)
            rear = null;
        return val;
    }
    
    public T peek() throws EmptyQueueException{
        if (front == null)
            throw new EmptyQueueException();
        return front.data;        
    }
    
    public boolean isEmpty() {
        return front==null;
    }
}
