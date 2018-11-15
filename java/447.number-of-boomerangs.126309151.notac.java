class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points.length < 3)
            return 0;
        int count = 0;
        int n = points.length;
        Set<int[]> set = new HashSet<>();
        for(int i = 0; i < n - 2; i++) {
            int x1 = points[i][0];
            int y1 = points[i][0];
            for(int j = i + 1; j < n - 1; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x1 == x2 && y1 == y2)
                    continue;            
                int dist1 = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
                for(int k = j + 1; k < n; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    if((x2 == x3 && y2 == y3) || (x1 == x3 && y1 == y3))
                        continue;
                    int dist2 = (x2-x3)*(x2-x3) + (y2-y3)*(y2-y3);
                    if(dist1 == dist2) {
                        count++;   
                    }                        
                }
            }
        }
       return 2 * count; 
    }
}
