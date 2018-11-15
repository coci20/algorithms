func pivotIndex(nums []int) int {
    if len(nums) == 0 || len(nums) == 2{
        return -1
    }
    if len(nums) == 1 {
        return 0
    }
    sums := make([]int, len(nums))
    sum := 0
    // for every index, get the sum
    for i := 0; i < len(nums); i++{
        sums[i] = sum + nums[i]
        sum += nums[i]
    }
    if sum - sums[0] == 0 {
        return 0
    }
    // at an index, i, sum before i
    for i := 1; i+1 < len(nums); i++{
        if sums[i-1] == sum - nums[i] - sums[i-1] {
            return i
        }
    }
    if sums[len(nums) - 2] == 0 {
        return len(nums)-1
    }
    return -1
}
