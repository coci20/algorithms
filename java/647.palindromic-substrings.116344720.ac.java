class Solution {
    
    public boolean isPalindromic(String s) {
        if (s.length() == 1)
            return true;
        int low = 0;
        int high = s.length()-1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high))
                return  false;
            low++;
            high--;
        }
        return true;
    }
    
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j <= s.length(); j++) {
                String ss = s.substring(i,j);
                if(isPalindromic(ss))
                    count++;
            }
        }
        return count;
    }
}
