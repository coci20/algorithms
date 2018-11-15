class Solution {
    public int monotoneIncreasingDigits(int N) {
        String strValue = String.valueOf(N);
        if(strValue.length() <= 1)
            return N;
        char[] digits = strValue.toCharArray();
        int i;
        for(i = 0; i < digits.length - 1; i++) {
            if(digits[i] - '0' > digits[i + 1] - '0')
                break;
        }
        if(i == digits.length - 1)
            return N;
        digits[i++]--;
        while(i < digits.length)
            digits[i++] = '9';
        String res = "";
        for(i = 0; i < digits.length && digits[i] == 0; i++) ;
        
        for(; i < digits.length; i++)
            res += digits[i];
        if(res.length() <= 1)
            return N;
        return monotoneIncreasingDigits(Integer.parseInt(res));
    }
}
