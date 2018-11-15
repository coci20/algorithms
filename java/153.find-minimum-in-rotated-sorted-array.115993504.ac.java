class Solution {
    
    public void findMinHelper(int[] nums, int low,
            int high, int[] min) {
        if (low > high) return;
        int mid = (low + high)/2;
        if (min[0] > nums[mid]) {
            min[0] = nums[mid];
        }
        if (mid >= low && mid <= high
                && nums[mid] >= nums[low]
                && nums[mid] <= nums[high]) {
            if (min[0] > nums[low]) min[0] = nums[low];
        } else if (mid >= low && nums[mid] > nums[high]){                   
                findMinHelper(nums, mid + 1, high, min);                
        } else if (mid <= high && nums[mid] < nums[low]){
                findMinHelper(nums, low, mid - 1, min);                
        }                
    }
    
    public int findMin(int[] nums) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        findMinHelper(nums, 0, nums.length - 1, min);
        return min[0];
    }
}
