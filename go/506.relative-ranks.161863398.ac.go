func findRelativeRanks(nums []int) []string {
    s := len(nums)
    if s == 1 {
        return []string{"Gold Medal"}
    } else if s == 2 {
        if nums[0] > nums[1] {
            return []string{"Gold Medal", "Silver Medal"}
        } else {
            return []string{"Silver Medal", "Gold Medal"}
        }
    }
    m := make(map[int]int)
    for i := 0; i < s; i++ {
        m[nums[i]] = i
    }
    relatives := make([]string, s)
    sort.Ints(nums)
    gold := nums[s - 1]
    silver := nums[s - 2]
    bronze := nums[s - 3]
    for k := range m {
        if k == gold {
            relatives[m[gold]] = "Gold Medal"
        } else if k == silver {
            relatives[m[silver]] = "Silver Medal"
        } else if k == bronze {
            relatives[m[bronze]] = "Bronze Medal"
        }
    }
    k := 4
    for i := s - 4; i >= 0; i-- {
        relatives[m[nums[i]]] = fmt.Sprintf("%d",k)
        k++
    }
    return relatives
}
