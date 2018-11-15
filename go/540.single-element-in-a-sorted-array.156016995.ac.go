func singleNonDuplicate(nums []int) int {
    m := make(map[int]int)
    for _, v := range nums {
        if _, ok := m[v]; !ok {
            m[v] = 1
        } else {
            m[v] += 1
        }
    }
    var res int
    for k := range m {
        if m[k] == 1 {
            res = k
        }
    }
    return res
}
