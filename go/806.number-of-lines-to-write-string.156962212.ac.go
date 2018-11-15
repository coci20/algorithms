func numberOfLines(widths []int, S string) []int {
    currLen := 0
    maxWidth := 100
    numLens := 0
    runes := []rune(S)
    alphaWidth := make(map[int]int)
    for i := 0; i < 26; i++{
        alphaWidth[i+97] = widths[i]
    }
    for i := 0; i < len(S); i++{
        currWidth := alphaWidth[int(runes[i])]
        if currLen + currWidth > maxWidth{
            currLen = currWidth
            numLens++
        } else {
            currLen += currWidth
        }
    }
    if currLen > 0{
        numLens++
    }
    return []int{numLens, currLen}
}
