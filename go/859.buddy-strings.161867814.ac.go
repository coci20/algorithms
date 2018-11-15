func isBuddy(A string) bool {
    m := make(map[rune]bool)
    runes := []rune(A)
    for _, v := range runes {
        if !m[v]{
            m[v] = true
        } else {
            return true
        } 
    }
    return false
}
func buddyStrings(A string, B string) bool {
    if len(A) != len(B) {
        return false
    }
    if A == B {
        return isBuddy(A)
    }
    index1 := -1
    index2 := -1
    runes1 := []rune(A)
    runes2 := []rune(B)
    // start from left
    for i := 0; i < len(A); i++{
        if runes1[i] != runes2[i] {
            index1 = i
            break
        }
    }
    
    // start from right
    for i := len(A) - 1; i >= 0; i--{
        if runes1[i] != runes2[i] {
            index2 = i
            break
        }
    }
    
    if index1 >= index2 {
        return false
    }
    // swap
    runes1[index1], runes1[index2] = runes1[index2], runes1[index1]
    for i := index1; i <= index2; i++ {
        if runes1[i] != runes2[i] {
            return false
        }
    }
    return true
}
