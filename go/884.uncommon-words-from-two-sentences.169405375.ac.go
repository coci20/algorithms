
func uncommonFromSentences(A string, B string) []string {
    words1 := strings.Split(A, " ")
    m := make(map[string]int)
    for _, v := range words1{
        if _, ok := m[v]; ok {
            m[v]++
        } else {
            m[v] = 1
        }
    }
    // fmt.Printf("%v\n", m)
    words2 := strings.Split(B, " ")
    for _, v := range words2{
        if _, ok := m[v]; ok {
            m[v]++
        } else {
            m[v] = 1
        }
    }
    // fmt.Printf("%v\n", m)
    var result []string
    for v := range m{
        if m[v] == 1{
            result = append(result, v)
        }
    }
    return result
}
