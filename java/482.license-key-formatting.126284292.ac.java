class Solution {
    public String licenseKeyFormatting(String S, int K) {
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            stack.push(S.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            String str = "";
            int len = 0;
            while(!stack.isEmpty() && len < K) {
                char c = stack.pop();
                if(c != '-') {
                    str += c;
                    len++;
                }
            }
            sb.append(str.toUpperCase());
            if(stack.isEmpty()) {
                break;
            }
            sb.append("-");
        }
        if(sb.length() == 0)
            return "";
        String ans = sb.reverse().toString();
        return ans.charAt(0) == '-' ? ans.substring(1) : ans;
    }
}
