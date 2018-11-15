func reverse(str string) string {
    rune := make([]rune, len(str))
    n := len(str)
    for _, v := range str{
        n--
        rune[n] = v
    }
    return string(rune[n:])
}
func maskPII(S string) string {
    if strings.Contains(S, "@") {
        strs := strings.Split(S, "@")
        first := strings.ToLower(strs[0])
        return string(first[0]) + "*****" + string(first[len(strs[0])-1]) + "@" + strings.ToLower(strs[1])
    } else {
        var res []rune
        runes := []rune(S)
        count := 0
        for i := len(runes) - 1; i >= 0; i--{
            if runes[i] >= '0' && runes[i] <= '9'{
                if count < 4 {
                    res = append(res, runes[i])
                } else if count >= 4 && count < 7 {
                    if count == 4 {
                        res = append(res, '-')
                    }
                    res = append(res, '*')
                } else if count >= 7 && count < 10 {
                    if count == 7 {
                        res = append(res, '-')
                    }
                    res = append(res, '*')
                } else if count >= 10 {
                    if count == 10 {
                        res = append(res, '-')
                    }
                    res = append(res, '*')
                }
            } else {
                continue
            }
            count++
        }
        if count > 10 {
            res = append(res, '+')
        }
        str := string(res)
        return reverse(str)
    }
    return S
}
