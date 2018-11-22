class Solution {
    
    public int binarySearch(int[] nums, int low, int high, int key) {
        if(low > high)  return -1;
        int mid = (low+high)/2;
        if(nums[mid] == key)
            return mid;
        else{
            if(nums[mid] > key)
                return binarySearch(nums, low, mid - 1, key);
            else
                return binarySearch(nums, mid + 1, high, key);
        }
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[2];
        pos[0] = -1;
        pos[1] = -1;
        int index = binarySearch(nums, 0, nums.length - 1, target);
        
        if(index == -1)     return pos;
        
        pos[0] = index;
        pos[1] = index;
            
        for(int i = index - 1; i >= 0; i--) {
            if(nums[i] == nums[index])
                pos[0] = i;
            else
                break;
        }
        
        for(int i = index + 1; i < nums.length; i++) {
            if(nums[i] == nums[index])
                pos[1] = i;
            else
                break;
        }
        
        return pos;
    }
}
