class Solution {
    public String addBinary(String a, String b) {
        int lena = a.length() - 1;
        int lenb = b.length() - 1;
        int i = 0;
        int j = 0;
        int carry = 0;
        Stack<Integer> st = new Stack<>();
        while (i <= lena && j <= lenb) {
            int c = (a.charAt(lena - i) - '0') + (b.charAt(lenb - j) - '0') + carry;
            st.push(c%2);
            if (c >= 2) carry = 1;
            else carry = 0;
            i++;
            j++;
        }        
        while(j <= lenb) {
            int c = b.charAt(lenb - j) - '0' + carry;
            if (c >= 2) carry = 1;
            else    carry = 0;
            st.push(c%2);
            j++;
        }
        while(i <= lena) {
            int c = a.charAt(lena - i) - '0' + carry;
            if (c >= 2) carry = 1;
            else    carry = 0;
            st.push(c%2);
            i++;
        }
        if (carry == 1) st.push(carry);
        String str="";
        while(!st.isEmpty()) {
            str += String.valueOf(st.pop());
        }
        return str;
    }
}
