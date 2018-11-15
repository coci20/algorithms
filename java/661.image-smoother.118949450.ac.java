class Solution {
    public int[][] imageSmoother(int[][] M) {
        
        int n = M.length;
        int m = M[0].length;
        
        int[][] MM = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                MM[i][j] = M[i][j];
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int sum = M[i][j];
                int count = 1;
                int i1, i2;
                
                i1 = i+1; i2 = j+1;
                if(i1 < n && i2 < m) {
                    count++;
                    sum += M[i1][i2];
                }
                    
                i1 = i-1; i2 = j-1;
                if(i1 >= 0 && i2 >= 0) {
                    count++;
                    sum += M[i1][i2];
                }
                    
                i1 = i-1; i2 = j+1;
                if(i1 >= 0 && i2 < m) {
                    count++;
                    sum += M[i1][i2];
                }
                    
                i1 = i+1; i2 = j-1;
                if(i1 < n && i2 >= 0) {
                    count++;
                    sum += M[i1][i2];
                }
                
                i1 = i; i2 = j+1;
                if(i1 >= 0 && i1 < n && i2 < m) {
                    count++;
                    sum += M[i1][i2];
                }
                    
                i1 = i; i2 = j-1;
                if(i1 >= 0 && i1 < n && i2 >= 0) {
                    count++;
                    sum += M[i1][i2];
                }
                    
                i1 = i+1; i2 = j;
                if(i1 < n && i2 >= 0 && i2 < m) {
                    count++;
                    sum += M[i1][i2];
                }
                    
                i1 = i-1; i2 = j;
                if(i1 >= 0 && i2 >= 0 && i2 < m) {
                    count++;
                    sum += M[i1][i2];
                }
                
                MM[i][j] = sum/count;
            }
        }
        return MM;
    }
}
