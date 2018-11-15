class Solution {
    public int[] constructRectangle(int area) {
        
        
        //not considering the base case
        int[] nums = new int[2];
        nums[0] = area;
        nums[1] = 1;
        
        int diff = nums[0] - nums[1];
        
        if (diff == 0) return nums;
        
        int wid = nums[1];
        int len = nums[0];
        for (int i = 2; wid <= len; i++) {
            if((area % i) == 0) {
                wid = i;
                len = area/i;
                if (wid > len)  break;
                int d = len - wid;
                if(d < diff) {
                    diff = d;
                    nums[0] = len;
                    nums[1] = wid;
                }
            }                
        }
        return nums;
    }
}
