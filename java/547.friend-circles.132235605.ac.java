class Solution {
    public void dfs(int[][] M, boolean[] visited, int row) {
        visited[row] = true;
        for(int i = 0; i < M.length; i++) {
            if(!visited[i] && M[row][i] == 1)
                dfs(M, visited, i);
        }
    }
    public boolean allVisited(boolean[] visited) {
        for(int i = 0; i < visited.length; i++)
            if(!visited[i])
                return false;
        return true;
    }
    public int findCircleNum(int[][] M) {
        if(M.length == 1)
            return 1;
        int n = M.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visited[i])
                continue;
            for(int j = i; j < n; j++) {
                if(M[i][j] == 1)
                    dfs(M, visited, i);
            }
            if(visited[i])
                count++;
            if(allVisited(visited))
                break;
        }
        return count;
    }
}
