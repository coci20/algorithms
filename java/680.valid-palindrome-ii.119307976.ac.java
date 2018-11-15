class Solution {
    
    public boolean rightPalindrome(String s) {
        int i, j, count;
        i = 0;
        j = s.length() - 1;
        count = 0;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if(count < 1 && s.charAt(i) == s.charAt(j - 1)) {
                    count++;
                    j--;
                } else
                    return false;
            }
        }
        return (i >= j);
    }
    
    public boolean leftPalindrome(String s) {
        int i, j, count;
        i = 0;
        j = s.length() - 1;
        count = 0;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if(count < 1 && s.charAt(i + 1) == s.charAt(j)) {
                    count++;
                    i++;
                } else
                    return false;
            }
        }
        return (i >= j); 
    }
    
    public boolean isPalindrome(String s) {
        int i, j;
        i = 0;
        j = s.length() - 1;
        while(i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return (i >= j);
    }
    
    public boolean validPalindrome(String s) {
        return isPalindrome(s) || leftPalindrome(s) || rightPalindrome(s);
    }        
}
