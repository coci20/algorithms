import "strings"
import "unicode"
func mostCommonWord(paragraph string, banned []string) string {
    x := func(c rune) bool {
        return !unicode.IsLetter(c)
    }
    strArray := strings.FieldsFunc(paragraph, x)
    myMap := make(map[string]int)
    for _, str := range strArray {
        lstr := strings.ToLower(str)
        if _, ok := myMap[lstr]; ok{
            myMap[lstr]++
        } else{
            myMap[lstr] = 1
        }
    }
    for _, str := range banned {
        if _, ok := myMap[str]; ok{
            myMap[str] = 0
        }
    }
    result := ""
    r := 0
    for key, val := range myMap{
        if r < val {
            result = key
            r = val
        }
    }
    return result
}
