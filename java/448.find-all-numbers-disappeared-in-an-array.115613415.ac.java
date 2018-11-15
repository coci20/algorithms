class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        int len = nums.length;
        int[] count = new int[len + 1];
        for (int i = 1; i <= len; i++)
            count[nums[i-1]]++;
        for (int i = 1; i <= len; i++)
            if (count[i] == 0) list.add(i);
        return list;
        
    }
}
