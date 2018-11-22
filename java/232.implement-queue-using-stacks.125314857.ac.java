class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> in = null;
    Stack<Integer> out = null;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {        
        while(!in.isEmpty())
            out.push(in.pop());
        int x = out.pop();
        while(!out.isEmpty())
            in.push(out.pop());
        return x;
    }
    
    /** Get the front element. */
    public int peek() {
        while(!in.isEmpty())
            out.push(in.pop());
        int x = out.peek();
        while(!out.isEmpty())
            in.push(out.pop());
        return x;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
