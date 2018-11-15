class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)      return 0;
        
        int i, j, n, max, min;
        n = prices.length;
        max = 0;
        min = prices[0];
        for(i = 0; i < n; i++) {
            if(prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}
