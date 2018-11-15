
func isPrime(n int) bool {
    if n == 1 {
        return false
    }
    for i := 2; i <= int(math.Sqrt(float64(n))); i++ {
        if n%i == 0 {
            return false
        }
    }
    return true
}
func isPalindrome(v int) bool {
    s := strconv.Itoa(v)
    runes := []rune(s)
    for i := 0; i < len(runes)/2; i++ {
        if runes[i] != runes[len(s)-i-1] {
            return false
        }
    }
    return true
}
func primePalindrome(N int) int {
    if N == 1 {
        return 2
    }
    if N == 2 || N == 5 || N == 7 {
        return N
    }
    v := N
    for {
        if v > 10 && (v%2 == 0 || v%3 == 0 || v%5 == 0 || v%7 == 0) {
            v++
            continue
        } 
        if isPrime(v) && isPalindrome(v) {
            //fmt.Printf("%d\n", v)
            break
        }
        v++
    }
    return v
}

