class Solution {

    List<Integer> list = new ArrayList<>();
    public Solution(int[] nums) {
        for(int i = 0; i < nums.length; i++)
            list.add(nums[i]);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] n = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            n[i] = list.get(i);
        return n;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] nums = new int[list.size()];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < list.size(); i++) {
            int v = (int)(Math.random() * list.size());
            while(set.contains(v) && set.size() < list.size()) {
                v = (int)(Math.random() * list.size());
            }
            set.add(v);            
            nums[i] = list.get(v);
        }
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
