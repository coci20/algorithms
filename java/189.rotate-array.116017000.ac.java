class Solution {
    public void rotate(int[] nums, int k) {
        int rot = k % nums.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++)
            st.push(nums[i]);        
        
        for (int i = rot-1; i >= 0; i--){
            int k1 = st.pop();
            nums[i] = k1;
        }
        for (int i = 0; !st.isEmpty(); i++) {
            int k1 = st.pop();
            nums[nums.length - 1 - i] = k1;
        }     
    }
}
