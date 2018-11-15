class Solution {
    public int uniquePaths(int m, int n, int[][] memo) {
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 || j == 1) {    
                    memo[i][j] = 1;
                } else {
                    memo[i][j] = memo[i-1][j] + memo[i][j-1];
                }
            }
        }
        return memo[m][n];
    }
    public int uniquePaths(int m, int n) {
        int[][] memos = new int[m + 1][n + 1];
        return uniquePaths(m, n, memos);
    }
}
