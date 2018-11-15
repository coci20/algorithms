func backHelper(S string) string {
    runes := []rune(S)
    back := 0
    str := ""
    for i := 0; i < len(S); i++{
        val := runes[len(S) - i -1]
        if val == '#'{
            back++
        } else {
            if back == 0 {
                str += string(val)
            } else {
                back--
            }
        }
    }
    return str
}
func backspaceCompare(S string, T string) bool {
    return strings.Compare(backHelper(S), backHelper(T)) == 0
}
