func kthSmallest(matrix [][]int, k int) int {
    var t []int
    for _, r := range matrix{
        for _, v := range r{
            t = append(t, v)
        }
    }
    sort.Ints(t)
    for i := 0; i < len(t); i++{
        if i == k-1 {
            return t[i]
        }
    }
    return -1
}
