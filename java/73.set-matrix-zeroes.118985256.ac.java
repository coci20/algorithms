class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] flag = new boolean[m][n];
        
        int i, j, k;
        for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    for(k = 0; k < m; k++)
                        flag[k][j] = true;
                    for(k = 0; k < n; k++)
                        flag[i][k] = true;
                }
            }
        }
        for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                if(flag[i][j] == true)
                    matrix[i][j] = 0;
            }
        }
    }
}
