func checkPossibility(nums []int) bool {
    i := len(nums) - 2
    maxSoFar := nums[len(nums) - 1] 
    count := 0
    for i >= 0 {
        if nums[i] <= maxSoFar {
            maxSoFar = nums[i]
            i--
            continue
        } else {
            i--
            count++
        }
        if count > 1{
            return false
        }
    }
    return true
}
