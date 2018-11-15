class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //map for nums2, with key as nums[i] and i as index, assuming no duplicates
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        
        int[] res = new int[nums1.length];
        
        //look for index in nums2 for each entry in nums1
        for(int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            int index = map.get(key);
            int j = index + 1;
            int ans = -1;
            while (j < nums2.length) {
                if (nums2[j] > key){
                    ans = nums2[j];
                    break;
                }
                j++;
            }
            res[i] = ans;
        }
        return res;
    }
}
