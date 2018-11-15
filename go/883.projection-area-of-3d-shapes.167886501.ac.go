func getTop(grid [][]int) int {
    count := 0
    for i := 0; i < len(grid); i++{
        for j := 0; j < len(grid[i]); j++{
            if grid[i][j] > 0 {
                count++
            }
        }
    }
    return count
}

// moving along X-axis get the maximum for each row
func getSideX(grid [][]int) int {
    sum := 0
    for _, r := range grid{
        max := 0
        for _, val := range r{
            if max < val{
                max = val
            }
        }
        sum += max
    }
    return sum
}

// moving along Y-axis get the maximum for each col
func getSideY(grid [][]int) int {
    sum := 0
    m, n := len(grid), len(grid[0])
    for i := 0; i < n; i++{
        max := 0
        for j := 0; j < m; j++{
            if max < grid[j][i]{
                max = grid[j][i]
            }
        }
        sum += max
    }
    return sum
}
func projectionArea(grid [][]int) int {
    return getTop(grid) + getSideX(grid) + getSideY(grid)
}
