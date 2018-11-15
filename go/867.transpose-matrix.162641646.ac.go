func transpose(A [][]int) [][]int {
    B := make([][]int, len(A[0]))
    for i := 0; i < len(A[0]); i++ {
        B[i] = make([]int, len(A))
    }
    for i := 0; i < len(A); i++{
        for j := 0; j < len(A[0]); j++{
            B[j][i] = A[i][j]
        }
    }
    return B
}
