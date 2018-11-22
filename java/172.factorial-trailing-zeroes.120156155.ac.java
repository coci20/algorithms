class Solution {    
    
    public int trailingZeroes(int n) {
        long m = (long)n;
        long count = 0;
        long base = 5;
        while(base <= m) {
            count += (m/base);
            base *= 5;
        }
        return (int)count;
    }    
}
