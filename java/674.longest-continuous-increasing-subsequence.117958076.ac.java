class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0)    return 0;
        int prev = 0;
        int cur = 1;
        int len = 1;
        int max = len;
        while(cur < nums.length) {
            if(nums[prev] < nums[cur])
                len++;
            else {
                if(max < len)
                    max = len;
                len = 1;
            }
            prev = cur;
            cur++;
        }
        if(max < len)
            max = len;
        return max;
    }
}
