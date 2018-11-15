class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)      return 0;
        
        int prev = prices[0];
        int sum = 0;
        int i;
        for(i = 1; i < prices.length; i++ ){
            if(prices[i] < prev) {
                prev = Math.min(prices[i], prev);
            } else {
                sum += prices[i] - prev;
                prev = prices[i];
            }
        }
        return sum;
    }
}
