class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> min = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty()) {
            min.push(x);
        } else {
            if(min.peek() >= x) {
                min.push(x);
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        int k = stack.pop();
        if(!min.isEmpty() && k == min.peek())
            min.pop();
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        return -1;
    }
    
    public int getMin() {
        if(!min.isEmpty())
            return min.peek();
        return -1;
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
