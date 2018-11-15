class Solution {
    public int thirdMax(int[] nums) {
        int[] pos = new int[3];
        pos[0] = -1;
        pos[1] = -1;
        pos[2] = -1;
        int max = Integer.MIN_VALUE; 
        int i;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] >= max) {
                max = nums[i];
                pos[0] = i;
            }
        }
        
        max = Integer.MIN_VALUE;
        for(i = 0; i < nums.length; i++) {
            if(pos[0] == i || nums[i] == nums[pos[0]])
                continue;
            if(max <= nums[i]) {
                max = nums[i];
                pos[1] = i;
            }
        }
        
        max = Integer.MIN_VALUE;
        for(i = 0; i < nums.length; i++) {
            if(pos[0] == i || pos[1] == i || nums[i] == nums[pos[0]] || nums[i] == nums[pos[1]])
                continue;
            if(max <= nums[i]) {
                max = nums[i];
                pos[2] = i;
            }
        }
        return pos[2] == -1 ? nums[pos[0]] : nums[pos[2]];
    }
}
