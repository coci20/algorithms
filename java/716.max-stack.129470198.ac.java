class MaxStack {

    Stack<Integer> stack;
    PriorityQueue<Integer> PQ;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        Comparator<Integer> comptr = 
            (Integer i1, Integer i2) -> i2 - i1;
        PQ = new PriorityQueue<>(comptr);
    }
    
    public void push(int x) {
        stack.push(x);
        PQ.add(x);
    }
    
    public int pop() {
        int k = stack.pop();
        if(k == PQ.peek())
            PQ.remove();
        else {
            Stack<Integer> temp = new Stack<>();
            while(k != PQ.peek()) {
                temp.push(PQ.remove());
            }
            PQ.remove();
            while(!temp.isEmpty()) {
                PQ.add(temp.pop());
            }
        }
        return k;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return PQ.peek();
    }
    
    public int popMax() {
        int k = PQ.remove();
        Stack<Integer> temp = new Stack<>();
        while(k != stack.peek()) {
            temp.push(stack.pop());
        }
        stack.pop();
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return k;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
