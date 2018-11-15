class Solution {
    public int arrayNesting(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int i;
        for(i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            int n = nums[i];
            while(!list.contains(n)) {
                list.add(n);
                n = nums[n];
            }
            lists.add(list);
        }
        int max = 0;
        for(i = 0; i < lists.size(); i++) {
            if(lists.get(i).size() > max)
                max = lists.get(i).size();
        }
        return max;
    }
}
