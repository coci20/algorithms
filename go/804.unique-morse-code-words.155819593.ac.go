func uniqueMorseRepresentations(words []string) int {
    values := []string{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}
    m := make(map[rune]string)
    index := 0
    for v := 'a'; v <= 'z'; v++{
        m[v] = values[index]
        index++
    }
    m1 := make(map[string]bool)
    for _, ss := range words {
        runes := []rune(ss)
        str := ""
        for _, r := range runes {
            str += m[r]
        }
        if !m1[str] {
            m1[str] = true
        }
    }
    return len(m1)
}
