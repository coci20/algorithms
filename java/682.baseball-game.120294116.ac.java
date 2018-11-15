class Solution {
    public int calPoints(String[] ops) {
        int i, sum;
        Stack<Integer> stack = new Stack<Integer>();
        sum = 0;
        for(String s : ops) {
            switch(s) {
                case "+" :
                    if(!stack.isEmpty()) {
                        int v1 = stack.pop();
                        if(!stack.isEmpty()) {
                            int v2 = stack.peek();
                            stack.push(v1);
                            stack.push(v1 + v2);
                            sum = sum + v1 + v2;
                        }
                    }     
                    break;
                case "D" :
                    if(!stack.isEmpty()) {
                        int v1 = stack.peek();
                        sum = sum + 2 * v1;
                        stack.push(2 * v1);                        
                    }
                    break;
                case "C" :
                    if(!stack.isEmpty()) {
                        int v1 = stack.pop();
                        sum = sum - v1;
                    }
                    break;
                default:
                    int point = Integer.parseInt(s);                    
                    stack.push(point);
                    sum += point;
            }
        }
        
        return sum;
    }
}
