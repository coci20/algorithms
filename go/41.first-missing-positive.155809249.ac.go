func firstMissingPositive(nums []int) int {
    if len(nums) == 0{
        return 1
    }
    m := make(map[int]bool)
    max := nums[0]
    for _, v := range nums{
        m[v] = true
        if max < v && v > 0 {
            max = v
        }
    }
    if max <= 0{
        return 1
    }
    if max == 1{
        return 2
    }
    i := 1
    for ; i < max; i++ {
        if !m[i] {
            return i
        }
    }
    if i == 1 {
        return 1
    } else {
        return i + 1
    }
}
