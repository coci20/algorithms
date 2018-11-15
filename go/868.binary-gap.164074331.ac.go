func binaryGap(N int) int {
    s := strconv.FormatInt(int64(N), 2)
    if !strings.Contains(s, "1") {
        return 0
    }
    bytes := []byte(s)
    dist := 0
    last := -1
    count := 0
    max := 0
    for i := 0; i < len(bytes); i++{
        if bytes[i] == '1' {
            count++
            if last >= 0{
                dist = i-last
                if max < dist {
                    max = dist
                }
                last = i
            } else {
                last = i
            }
        }
    }
    if count <= 1{
        return 0
    }
    return max
}
