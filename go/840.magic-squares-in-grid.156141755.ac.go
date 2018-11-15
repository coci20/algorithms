func isMagic(grid [][]int, x, y, w, row, col int) bool {
	m := make(map[int]bool)
	var sums []int
    for i := x; i < x+w && i < row; i++ {
		s := 0
		for j := y; j < y+w && j < col; j++ {
			n := grid[i][j]
			if n > 9 || n == 0 {
				return false
			} else if !m[n] {
				m[n] = true
				s += n
			} else {
				return false
			}
		}
		sums = append(sums, s)
	}
    for i := y; i < y+w && i < col; i++ {
		s := 0
		for j := x; j < x+w && j < row; j++ {
			n := grid[j][i]
			s += n
		}
		sums = append(sums, s)
	}
    s := 0
	for i := 0; i < w && i+x<row && i+y < col; i++ {
		s += grid[i+x][i+y]
	}
	sums = append(sums, s)
    s = 0
	for i := 0; i < w && y+i < col && x+w-i >= 1; i++ {
		s += grid[x+w-i-1][y+i]
	}
	sums = append(sums, s)
    s = sums[0]
	for _, v := range sums {
		if v != s {
			return false
		}
	}
    return true
}
func numMagicSquaresInside(grid [][]int) int {
    w := 3
    count := 0
	for i := 0; i <= len(grid)-w; i++ {
		for j := 0; j <= len(grid[i])-w; j++ {
			if isMagic(grid, i, j, w, len(grid), len(grid[i])) {
				count++
			}
		}
	}
    return count
}
