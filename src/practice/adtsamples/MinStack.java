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
public class MinStack {
    /** initialize your data structure here. */
    MinStack stackTop;
    int val;
    MinStack next;
    int min;
    public MinStack() {
        stackTop = null;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        MinStack stack = new MinStack();
        stack.val = x;
        next = null;
        if(stackTop == null)
            stackTop = stack;
        else {
            stack.next = stackTop;
            stackTop = stack;
        }
        if(x < min) {
            stack.min = x;
            min = x;
        } else {
            stack.min = min;
        }
    }
    
    public void pop() {
        if(stackTop != null) {
            stackTop = stackTop.next;
        }
    }
    
    public int top() {
        if(stackTop != null) {
            return stackTop.val;
        }
        return Integer.MAX_VALUE;
    }
    
    public int getMin() {
        if(stackTop != null) {
            return stackTop.min;
        }
        return Integer.MAX_VALUE;
    }
    
    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

