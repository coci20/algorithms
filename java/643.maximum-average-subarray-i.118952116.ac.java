class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        
        int sum, i, j;
        i = 0;
        while(i < n) {
            sum = 0;
            for(j = i; j < k+i && j < n; j++)
                sum += nums[j];
            if(sum > max)   max = sum;
            if(j == n)  break;
            else
                i++;
        }
        return (double)max/k; 
    }
}
