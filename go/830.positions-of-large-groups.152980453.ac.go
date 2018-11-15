func largeGroupPositions(S string) [][]int {
    var L [][]int
    for i := 0; i < len(S); {
        index := i
        count := 0
        c := S[i]
        for i < len(S) && c == S[i] {
            i = i + 1
            count = count + 1
        }
        if count >= 3 {
            var l []int
            l = append(l, index)
            l = append(l, index + count - 1)
            L = append(L, l)
        }
    }
    return L
}
