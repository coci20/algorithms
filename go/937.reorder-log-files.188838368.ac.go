func compareLexic(a, b []string) int {
   // fmt.Printf("comparing %v and %v\n", a, b)
    i, j := 0, 0
    for i < len(a) && j < len(b) {
        if strings.Compare(a[i], b[j]) > 0{
            return 1
        } else if strings.Compare(a[i], b[j]) < 0{
            return -1
        } else {
            i++
            j++
        }
    } 
    if len(a) < len(b) {
        return -1
    } else if len(a) > len(b) {
        return 1
    }
    return 0
}
func sortLexic(letterLogs []string, v string) []string {
    if len(letterLogs) < 1 {
        return []string{v}
    }
    parts1 := strings.Split(v, " ")
    for i := 0; i < len(letterLogs); i++{
        parts2 := strings.Split(letterLogs[i], " ")
        val := compareLexic(parts1[1:], parts2[1:])
        if val == 0 {
            if strings.Compare(parts1[0], parts2[0]) > 0 {
                continue
            } else {
                var temp []string
                temp = append(temp, letterLogs[:i]...)
                temp = append(temp, v)
                temp = append(temp, letterLogs[i:]...)
                return temp
            }
        } else if val == 1 {
            continue
        } else {
            var temp []string
            temp = append(temp, letterLogs[:i]...)
            temp = append(temp, v)
            temp = append(temp, letterLogs[i:]...)
            return temp
        }
    }
    letterLogs = append(letterLogs, v)
    return letterLogs
}
func reorderLogFiles(logs []string) []string {
    var letterLogs, digitLogs []string
    re := regexp.MustCompile(`(?m)^\d+$`)
    for _, v := range logs {
        parts := strings.Split(v, " ")
        if re.MatchString(parts[1]) {
            digitLogs = append(digitLogs, v)
        } else {
            letterLogs = sortLexic(letterLogs, v)
        }
    }
    var result []string
    result = append(result, letterLogs...)
    result = append(result, digitLogs...)
    return result
}
