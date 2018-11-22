func countSegments(s string) int {
    strs := strings.Split(s, " ")
    count := 0
    for _, v := range strs{
        if v != ""{
            count++
        }
    }
    return count
}
