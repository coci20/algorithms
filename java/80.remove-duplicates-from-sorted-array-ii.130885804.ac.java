class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int k : nums) {
            if(i < 2 || k > nums[i - 2])
                nums[i++] = k;
        }
        return i;
    }
}
