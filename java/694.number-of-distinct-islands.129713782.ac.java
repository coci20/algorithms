class Solution {
    public void addToList(int[][] grid,
                         int m, int n,
                         boolean[][] visited,
                         int i, int j,
                         List<List<Integer>> list) {
        int r = i + 1;
        int c = j + 1;
        if(r < m && j < n && !visited[r][j]) {
            visited[r][j] = true;
            if(grid[r][j] == 1) {
                list.add(Arrays.asList(r, j));
                addToList(grid, m, n, visited, r, j, list);
            }
        }
        if(i < m && c < n && !visited[i][c]) {
            visited[i][c] = true;
            if(grid[i][c] == 1) {
                list.add(Arrays.asList(i, c));
                addToList(grid, m, n, visited, i, c, list);
            }
        }
        r = i - 1;
        c = j - 1;
        if(r >= 0 && j >= 0 && !visited[r][j]) {
            visited[r][j] = true;
            if(grid[r][j] == 1) {
                list.add(Arrays.asList(r, j));
                addToList(grid, m, n, visited, r, j, list);
            }
        }
        if(i >= 0 && c >= 0 && !visited[i][c]) {
            visited[i][c] = true;
            if(grid[i][c] == 1) {
                list.add(Arrays.asList(i, c));
                addToList(grid, m, n, visited, i, c, list);
            }
        }
    }
    List<List<Integer>> processList(List<List<Integer>> lists) {
        List<List<Integer>> pairs = new ArrayList<>();
        if(lists.size() == 1) {
            pairs.add(Arrays.asList(0, 0));
            return pairs;
        }
        for(int i = 1; i < lists.size(); i++) {
            pairs.add(Arrays.asList(lists.get(i).get(0) - lists.get(i - 1).get(0),
                                   lists.get(i).get(1) - lists.get(i - 1).get(1)));
        }
        return pairs;
    }
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        Set<List<List<Integer>>> set = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j])
                    continue;
                visited[i][j] = true;
                if(grid[i][j] == 1) {
                    List<List<Integer>> list = new ArrayList<>();
                    list.add(Arrays.asList(i, j));
                    addToList(grid, m, n, visited, i, j, list);
                    set.add(processList(list));
                }
            }
        }
        return set.size();
    }
}
