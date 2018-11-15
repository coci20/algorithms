func rotateString(A string, B string) bool {
    if len(A) != len(B) {
        return false
    }
    if strings.Compare(A, B) == 0 {
        return true
    }
    A += A
    for i := 1; i < len(B); i++{
        runes := []rune(A)
        if strings.Compare(string(runes[i:len(B)+i]), B) == 0{
            return true
        }
    }
    return false
}
