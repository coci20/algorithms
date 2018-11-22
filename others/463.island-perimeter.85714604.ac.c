int islandPerimeter(int** grid, int gridRowSize, int gridColSize) {
    int count=0;
    for(int i=0;i<gridRowSize;i++){
        for(int j=0;j<gridColSize;j++){
            if(grid[i][j]==1){
                if((i-1)>=0 && grid[i-1][j]==0){
                    count++;
                }
                if((i+1)<gridRowSize && grid[i+1][j]==0){
                    count++;
                }
                if((j+1)<gridColSize && grid[i][j+1]==0){
                    count++;
                }
                if((j-1)>=0 && grid[i][j-1]==0){
                    count++;
                }
                if(i==0){
                    count++;
                }
                if(j==0){
                    count++;
                }
                if(i==gridRowSize-1){
                    count++;
                }
                if(j==gridColSize-1){
                    count++;
                }
            }
        }
        
    }
    return count;
}
