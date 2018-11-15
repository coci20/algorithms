class Solution {
    public int findPairs(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int i, j;
        for(i = 0; i < nums.length; i++)
            list.add(nums[i]);
        Collections.sort(list);
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            for(j = i+1; j < list.size() && (list.get(j)) - a <= k; j++) {
                if((list.get(j) - a) == k)
                    set.add(a);
            }
        }
        return set.size();
    }
}
