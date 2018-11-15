func shiftRune(b rune, k int) rune {
    for i := 0; i < (k%26) ; i++{
        if b == 'z' {
            b = 'a'
        } else {
            b = b+1
        }
    }
    return b
}
func shiftingLetters(S string, shifts []int) string {
    runes := []rune(S)
    //get sum
    sum := 0
    for _, v := range shifts{
        sum += v
    }
    for i := 0; i < len(runes); i++{
        runes[i] = shiftRune(runes[i], sum)
        sum = sum-shifts[i]
    }
    return string(runes)
}
