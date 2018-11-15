class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return s.charAt(0) != '0' ? 1 : 0;
        int n = s.length();
        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
        for(int i = n - 2; i >= 0; i--) {
            if(s.charAt(i) == '0')
                continue;
            if(Integer.parseInt(s.substring(i, i + 2)) <= 26)
                memo[i] = memo[i + 1] + memo[i + 2];
            else
                memo[i] = memo[i + 1];
        }
        return memo[0];
    }
}
