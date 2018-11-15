class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0)    return 0;
        
        int[] LIS = new int [nums.length];
        int[] M = new int[nums.length];
        
        int i, j, count, max;
        int len = nums.length;
        
        for(i = 0; i < len; i++) {
            LIS[i] = 1;
            M[i] = 1;
        }        
        
        j = 0;
        for(i = 1; i < len; i++) {
            while(j < i) {
                if(nums[j] < nums[i]) {
                    count = LIS[i];
                    if(count < (LIS[j] + 1))
                        LIS[i] = LIS[j] + 1;
                    else {
                        if(LIS[i] == LIS[j]+1)
                            M[i]++;
                    }
                }
                j++;
            }
            j = 0;
        }
        
        count = LIS[0];
        for(i = 1; i < len; i++) {
            if(count < LIS[i])
                count = LIS[i];
        }        
        
        max = 0;
        for(i = 0; i < len; i++) {
            if(LIS[i] == count)
                max = max + M[i];
        }
        return max;
    }
}
