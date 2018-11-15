var m1 map[int]bool
var m2 map[int]bool
func isPrime(N int) bool {
    if m1[N] {
        return true
    }
    if m2[N] {
        return false
    }
    for i := 2; i <= int(math.Floor(math.Sqrt(float64(N)))); i++{
        if N % i == 0 {
            m2[N] = true
            return false
        }
    }
    if N > 1 {
        m1[N] = true
        return true
    }
    return false
}
func hasPrimeCounts(V string) bool {
    runes := []rune(V)
    n := 0
    for _, v := range runes {
        if v == '1' {
            n++
        }
    }
    return isPrime(n)
}
func countPrimeSetBits(L int, R int) int {
    c := 0
    m1 = make(map[int]bool)
    m2 = make(map[int]bool)
    for i := L; i <= R; i++ {
        if hasPrimeCounts(strconv.FormatInt(int64(i), 2)) {
            c++
        }
    }
    return c
}
