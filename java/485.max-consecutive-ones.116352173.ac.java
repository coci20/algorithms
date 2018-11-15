class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int max = 0;
        while (i < nums.length) {
            int count = 0;
            if (nums[i] == 1) {
                i = i + 1;
                count++;
                while(i < nums.length && nums[i] == 1) {
                    i++;
                    count++;
                }
                if (i <= nums.length) {
                    if (max < count)
                        max = count;
                }
                while (i < nums.length && nums[i] == 0) {
                    i++;                    
                }
            } else {
                i++;
            }            
        }
        return max;
    }
}
