class Solution {
    
    public boolean allEqual(int[] nums) {
        int key = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(key != nums[i])
                return false;
        }
        return true;
    }
    
    public int getMax(int[] nums){
        int maxIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
    
    public boolean restEqual(int[] nums, int maxIndex) {
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i != maxIndex) {
                k = i;
                break;
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (i == maxIndex)
                continue;
            else if (nums[k] != nums[i])
                return false;
        }
        return true;
    }
    
    public int minMoves(int[] nums) {
        if (nums.length == 1) return 0;  
        
        int maxIndex = getMax(nums);
        
        if (restEqual(nums, maxIndex)) {
            for(int i = 0; i < nums.length; i++) {
                if (i != maxIndex)
                    return nums[maxIndex] - nums[i];
            }
        }
        
        int count = 0;
        
        while(!allEqual(nums)) {            
            maxIndex = getMax(nums);            
            for (int i = 0; i < nums.length; i++) {
                if(i == maxIndex)   continue;
                else {
                    nums[i]++;
                }
            }
            count++;
        }
        return count;
    }
}
