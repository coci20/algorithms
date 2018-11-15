func getDivSum(num int) int {
    sum := 0
    for i := 2; i <= int(math.Floor(math.Sqrt(float64(num)))); i++{
        if num%i == 0{
            sum += i
            sum += (num/i)
        }
    }
    return 1+sum
}
func checkPerfectNumber(num int) bool {
    if num == 1 {return false}
    m := getDivSum(num)
    return m == num
}
