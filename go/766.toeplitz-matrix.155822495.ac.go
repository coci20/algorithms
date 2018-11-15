func isToeplitzMatrix(matrix [][]int) bool {
    m := make(map[int]int)
    index := 0
    for i := 0; i < len(matrix); i++{
        for j := 0; j < len(matrix[i]); j++{
            m[index] = matrix[i][j]
            index++
        }
    }
    index = len(matrix[0]) + 1
    for i := 0; i < len(matrix) - 1; i++{
        for j := 0; j < len(matrix[i]) - 1; j++{
            if matrix[i][j] != m[index] {
                return false
            }
            index++
            if index >= len(m) {
                return true
            }
        }
        index++
    }
    return true
}
