func getSum(X []int) int {
    sum := 0
    for _, v := range X{
        sum += v
    }
    return sum
}
func getMap(X []int) map[int]bool{
    m := make(map[int]bool)
    for _, v := range X{
        m[v] = true
    }
    return m
}
func fairCandySwap(A []int, B []int) []int {
    sumA := getSum(A)
    sumB := getSum(B)
    m1 := getMap(A)
    m2 := getMap(B)
    sum := (sumA+sumB)/2
    if sumA > sum{
        for _, v := range A{
            if m2[sum+v-sumA]{
                return []int{v, sum+v-sumA}
            }
        }
    } else {
        for _, v := range B{
            if m1[sum+v-sumB]{
                return []int{sum+v-sumB, v}
            }
        }
    }
    return []int{}
}
