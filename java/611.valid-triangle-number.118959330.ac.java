class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(nums[i]);
        Collections.sort(list);
        for(int i = 0; i < n - 2 ; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n && (list.get(k) < list.get(i) + list.get(j)); k++, count++)   ;
            }
        }
        return count;
    }
}
