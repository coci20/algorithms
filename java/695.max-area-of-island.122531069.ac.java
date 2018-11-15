class Solution {
    
    public void updateGrid(int[][] grid, int row, int col, int[] count) {
        if(grid[row][col] == 1) {
            grid[row][col] = 0;
            count[0]++;            
            if(row+1 < grid.length)
                updateGrid(grid, row+1, col, count);
            if(col+1 < grid[row].length)
                updateGrid(grid, row, col+1, count);
            if(row >= 1)
                updateGrid(grid, row-1, col, count);
            if(col >= 1)
                updateGrid(grid, row, col-1, count);
        } 
    }
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int[] count = new int[1];
                    updateGrid(grid, i, j, count);
                    area = Math.max(area, count[0]);
                }
            }
        }
        return area;
    }
}
