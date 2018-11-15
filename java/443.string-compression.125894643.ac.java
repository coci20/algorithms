class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if(n < 2)
            return n;
        int index = 1;
        for(int i = 1; i < n && index < n; i++, index++) {
            if(chars[i-1] == chars[i]) {
                int count = 1;
                while(i < n && chars[i-1] == chars[i]) {
                    count++;
                    i++;
                }
                String str = String.valueOf(count);
                for(int k = 0; k < str.length() 
                    && index < n; k++, index++)
                    chars[index] = str.charAt(k);
            }
            if(i == n)
                return index;
            chars[index] = chars[i];
        }
        return index;
    }
}
