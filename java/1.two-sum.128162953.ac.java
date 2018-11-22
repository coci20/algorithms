class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] pos = new int[2];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(!list.isEmpty() && list.contains(target - nums[i])) {
                pos[1] = i;
                pos[0] = list.indexOf(target - nums[i]);
                return pos;
            }
            list.add(nums[i]);
        }
        return pos;
    }
}
