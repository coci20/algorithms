class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if(map.containsKey(count))
                max = Math.max(max, i - map.get(count));
            if(!map.containsKey(count))
                map.put(count, i);
        }
        return max;
    }
}
