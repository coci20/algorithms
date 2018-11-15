class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int total = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            total += k;
            if (!list.contains(k))
                list.add(k);
            else
                sum += k;
        }
        list.clear();
        return (total - (2 * sum));
    }
}
