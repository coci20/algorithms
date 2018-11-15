class Solution {
    public int climbStairs(int n) {
        if(n <=1)   return 1;
        if(n == 2)  return 2;
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        int i;
        for(i = 2; i < n; i++)
            nums[i] = nums[i-1] + nums[i-2];
        return nums[n-1];
    }
}
