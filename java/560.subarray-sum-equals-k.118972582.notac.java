class Solution {
    public int subarraySum(int[] nums, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        int i, j, val;
        int count = 0;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] == k)    count++;
            List<Integer> list = new ArrayList<>();
            for(j = 0; j < lists.size(); j++) {
                val = nums[i] + lists.get(lists.size() - 1).get(j);
                list.add(val);
                if(val == k)    count++;
            }
            list.add(nums[i]);
            lists.add(list);
        }
        return count;
    }
}
