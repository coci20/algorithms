func testIso(s1, s2 string) bool {
	runes1 := []rune(s1)
	runes2 := []rune(s2)
	forwardMap := make(map[rune]rune)
	revMap := make(map[rune]rune)
	for i, v := range runes2 {
		if _, ok := forwardMap[runes1[i]]; !ok {
			forwardMap[runes1[i]] = v
            if _, ok := revMap[v]; ok {
                return false
            }
			revMap[v] = runes1[i]
		} else {
			if revMap[v] != runes1[i] {
				return false
			}
		}
	}
	return true
}
func findAndReplacePattern(words []string, pattern string) []string {
    var result []string
    for _, v := range words{
        if testIso(v, pattern) {
            result = append(result, v)
        }
    }
    return result
}
