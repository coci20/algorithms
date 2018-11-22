class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    int len = 1;
                    boolean flag = true;
                    while(flag && i + len < m && j + len < n) {
                        for(int k = j; k <= j + len; k++) {
                            if(matrix[i + len][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for(int k = i; k <= i + len; k++) {
                            if(matrix[k][j + len] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if(flag == true) {
                            len++;                            
                        }
                    }
                    max = Math.max(max, len);
                }
            }
        }
        return max * max;
    }
}
