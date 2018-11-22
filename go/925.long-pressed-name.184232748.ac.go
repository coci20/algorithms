func getCounts(s string) (string, []int) {
    runes := []rune(s)
    str := ""
    var values []int
    for i := 0; i < len(runes); {
        c := runes[i]
        str += string(c)
        count := 1
        j := i+1
        for ; j < len(runes); j++{
            if c != runes[j] {
                break
            }
            count++
        }
        i = j
        values = append(values, count)
    }
    return str, values
}
func isLongPressedName(name string, typed string) bool {
    v1, v2 := getCounts(name)
    v3, v4 := getCounts(typed)
    if v1 != v3 {
        return false
    }
    for i := 0; i < len(v2); i++{
        if v2[i] > v4[i]{
            return false
        }
    }
    return true
}
