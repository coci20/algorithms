func arrangeCoins(n int) int {
    if n == 0 {
        return 0
    }
    count := 0
    sum := 0
    for {
        count++
        sum += count
        if sum == n{
            break
        }
        if sum > n{
            count--
            break
        }
    }
    return count
}
