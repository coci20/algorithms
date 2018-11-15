class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        int x = 1;
        while(x <= n) {
            if(x % 2 == 1)
                x <<= 1;
            else {
                x <<= 1;
                x += 1;
            }
            if(x < 0)
                return false;
            if(x==n)
                break;
        }
        return (x == n);
    }
}
