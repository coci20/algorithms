func findNthDigit(n int) int {
    if n == 0{
        return 0
    }
    num := 1
    count := 0
    digit := 1
    for {
        if count == n{
            break
        }
        v := fmt.Sprintf("%d",num)
        runes := []rune(v)
        for i := 0; i < len(runes); i++{
            digit = int(runes[i]-'0')
            count++
            if count == n{
                return digit
            }
        }
        num++
    }
    return digit
}
