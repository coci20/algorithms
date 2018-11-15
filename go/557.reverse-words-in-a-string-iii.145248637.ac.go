func Reverse(s string) string {
    r := []rune(s)
    for i, j := 0, len(r)-1; i < len(r)/2; i, j = i+1, j-1 {
        r[i], r[j] = r[j], r[i]
    }
    return string(r)
}

func reverseWords(s string) string {
    parts := strings.Split(s, " ")
    var result string
    for _, v := range(parts) {
        result += Reverse(v)
        result += " "
    }
    return strings.Trim(result, " ")
}
