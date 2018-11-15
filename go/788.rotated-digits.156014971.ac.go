func mappedVal(num rune) rune {
    if num == '0' || num == '1' || num == '8' {
        return num
    } else if num == '2' {
        return '5'
    } else if num == '5' {
        return '2'
    } else if num == '6' {
        return '9'
    } else if num == '9' {
        return '6'
    }
    return num
}
func isGood(num int) bool {
    str := strconv.Itoa(num)
    runes := []rune(str)
    var newval []rune
    for _, r := range runes{
        if r == '3' || r == '4' || r == '7' {
            return false
        }
        newval = append(newval, mappedVal(r))
    }
    return strings.Compare(str, string(newval)) != 0
}
func rotatedDigits(N int) int {
    count := 0
    for i := 1; i <= N; i++{
        if isGood(i) {
            count++
        }
    }
    return count
}
