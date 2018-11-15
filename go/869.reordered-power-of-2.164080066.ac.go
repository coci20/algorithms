
func getPowersOf2(n int) ([]int, bool) {
    var powers []int
    high := int(math.Pow(10, 9))
    for p := 1; p <= high; p *= 2{
        powers = append(powers, p)
        if n == p {
            return powers, true
        }
    }
    return powers, false
}
func generateStrings(powers []int, l int) []string {
    var result []string
    for _,v := range powers{
        s := convertAndSortDigits(v)
        result = append(result, s)
        if len(s) > l {
            break
        }
    }
    return result
}
func convertAndSortDigits(n int) string {
    s := strconv.Itoa(n)         // convert the number to a string
	strs := strings.Split(s, "") // break into []string
	sort.Strings(strs)           // sort the strings
	return strings.Join(strs, "")   // join the strings
}
func reorderedPowerOf2(N int) bool {
    s1 := convertAndSortDigits(N)
    powers, val := getPowersOf2(N)
    if val == true {
        return true
    }
    results := generateStrings(powers, len(s1))
    //fmt.Printf("%s\n%v\n", s1, results)
    for i := 0; i < len(results); i++{
        if s1 == results[i] {
            return true
        }
    }
    return false
}
