class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if ((nums.length * nums[0].length) != (r * c)) return nums;
        
        int[] fullnum = new int[r * c];
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                fullnum[k] = nums[i][j];
                k++;
            }
        }
        
        k = 0;
        int[][] ans = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                ans[i][j] = fullnum[k];
                k++;
            }
        }
        
        return ans;
    }
}
