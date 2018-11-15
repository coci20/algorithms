class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0) return num1;
        if (num2.length() == 0) return num2;
        
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int carry = 0;
        
        Stack<Integer> st = new Stack<>();
        
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        
        while (n1 >= 0 && n2 >= 0) {
            int p1 = c1[n1] - '0';
            int p2 = c2[n2] - '0';
            int sum = p1 + p2 + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;
            st.push(sum%10);
            n1--;
            n2--;
        }
        
        while (n1 >= 0) {
            int p1 = c1[n1] - '0';
            int sum = p1 + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;
            st.push(sum%10);
            n1--;
        }
        
        while (n2 >= 0) {
            int p2 = c2[n2] - '0';
            int sum = p2 + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;
            st.push(sum%10);
            n2--;
        }
        
        if (carry == 1)
            st.push(carry);
        
        String str = "";
        while(!st.empty()) {
            str+=st.peek();
            st.pop();
        }
        
        return str;
    }
}
