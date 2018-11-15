func maxCount(m int, n int, ops [][]int) int {
    count := 0
    for k := 0; k < len(ops); k++ {
        rw := ops[k][0]
        co := ops[k][1]
        for i := 0; i < rw; i++{
            for j := 0; j < co; j++{
                if rw*co < count && count > 0{
                    count = rw*co
                } else if count == 0{
                    count = rw*co
                }
            }
        }
    }
    if count == 0 {
        return m*n
    }
    return count
}
