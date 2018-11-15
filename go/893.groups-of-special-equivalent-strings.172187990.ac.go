func processString(s string) string {
    runes := []rune(s)
    var (
        even, odd []string
        evenIndex, oddIndex int
        composite string
    )
    for i := 0; i < len(runes); i++{
        if i%2 == 0{
            even = append(even, string(runes[i]))    
        } else {
            odd = append(odd, string(runes[i]))
        }
    }
    sort.Strings(even)
    sort.Strings(odd)
    for i := 0; i < len(runes); i++{
        if i%2 == 0 {
            composite += even[evenIndex]
            evenIndex++
        } else {
            composite += odd[oddIndex]
            oddIndex++
        }
    }
    return composite
}
func numSpecialEquivGroups(A []string) int {
    m := make(map[string]bool)
    for _, v := range A{
        res := processString(v)
        if !m[res] {
            m[res] = true
        }
    }
    return len(m)
}
