class Solution {
    public void rotate(int[][] A) {
        int n = A.length;
        for(int i = 0; i < n; i++) {
            int ci = 0;
            int cj = n - 1;
            while(ci < cj) {
                int t = A[i][ci];
                A[i][ci] = A[i][cj];
                A[i][cj] = t;
                ci++;
                cj--;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                int t = A[i][j];
                A[i][j] = A[n - 1 - j][n - 1 - i];
                A[n - 1 - j][n - 1 - i] = t;
            }
        }
    }
}
