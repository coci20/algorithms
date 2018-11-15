class Solution {
    public String reverseStr(String s, int k) {
        if(s.length() == 1 || k == 1)
            return s;        
        
        int i = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while(i < s.length()) {
            int count = 0;
            while(count < k) {
                char c = s.charAt(i);
                stack.push(c);
                count++;
                i++;
                if(i == s.length())
                    break;
            }
            count = 0;
            while(!stack.empty()) {
                sb.append(stack.pop());
            }
            if(i == s.length()) break;
            while(count < k) {
                sb.append(s.charAt(i));
                count++;
                i++;
                if(i == s.length()) break;
            }            
        }
        return sb.toString();
    }
}
