func numJewelsInStones(J string, S string) int {
    m := make(map[rune]bool)
    runes := []rune(J)
    for _, v := range runes {
        m[v] = true
    }
    c := 0
    runes = []rune(S)
    for _, v := range runes {
        if m[v] {
            c++
        }
    }
    return c
}
