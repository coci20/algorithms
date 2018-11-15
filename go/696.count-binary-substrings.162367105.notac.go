
func countBinarySubstrings(s string) int {
    if strings.Contains(s, "0") && !strings.Contains(s, "1") {
        return 0
    }
    if !strings.Contains(s, "0") && strings.Contains(s, "1") {
        return 0
    }
    myString := ""
    size := 1
    counter := 0
    strZero := ""
    strOne := ""
    for size <= len(s)/2 {
        strZero += "0"
        strOne += "1"
        count1 := 0
        count2 := 0
        myString = strZero + strOne
        count1 += strings.Count(s, myString)
        myString = strOne + strZero
        count2 += strings.Count(s, myString)
        counter += count1 + count2
        if count1 == 0 && count2 == 0 {
            return counter
        }
        size++
    }
    return counter
}
