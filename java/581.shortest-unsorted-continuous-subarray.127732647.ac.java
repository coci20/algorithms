class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1)
            return 0;
        int low = -1, high = -1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                int j = i - 1;
                int x = nums[i];
                high = i;
                while(j >= 0 && nums[j] > x) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = x;
                if(low < 0)
                    low = j + 1;
                if(j + 1 < low)
                    low = j + 1;
            }
        }
        if(low < 0)
            return 0;
        return high - low + 1;
    }
}
