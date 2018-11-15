func consecutiveCards(myMap map[int]bool) bool {
    if len(myMap) == 1 {
        return true
    }
    // first sort the keys in the map, use a temp array
    var temp []int
    for key := range myMap{
        temp = append(temp, key)
    }
    sort.Ints(temp)
    first := temp[0]
    for i := 1; i < len(temp); i++{
        if temp[i] != first+i{
            return false
        }
    }
    return true
}
func isNStraightHand(hand []int, W int) bool {
    if W == 1 {
        return true
    }
    if len(hand)%W != 0 {
        return false
    }
    
    // each group should have W cards and the cards should be consecutive
    sort.Ints(hand)
    groups := len(hand)/W
    maps := make([]map[int]bool, groups)
    for i := 0; i < groups; i++{
        maps[i] = make(map[int]bool)
    }
    for i := 0; i < len(hand); i++{
        done := false
        for j := 0; j < groups; j++{
            if !maps[j][hand[i]] && len(maps[j]) < W {
                maps[j][hand[i]] = true    // in jth map add hand[i]
                done = true
                break
            }
        }
        if !done {
            return false
        }
    }
    // len of all maps should be W
    for _, r := range maps {
        if len(r) != W {
            return false
        }
    }

    // every map should have consecutive card numbers
    for _, r := range maps {
        if !consecutiveCards(r) {
            return false
        }
    }
    return true
}
