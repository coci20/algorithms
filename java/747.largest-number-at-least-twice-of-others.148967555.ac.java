class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;
        int max = nums[0];
        int min = nums[0];
        int p = 0;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                p = i;
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min && i != p) {
                index = i;
                min = nums[i];
            }
        }
        if (index == -1) {
            return max >= 2 * min ? p : -1;
        }
        return max >= 2 * nums[index] ? p : -1;
    }
}
