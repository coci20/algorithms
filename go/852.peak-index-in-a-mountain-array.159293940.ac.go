func isPeak(index int, A []int) bool {
    
    for i := index-1; i >= 0; i--{
        if A[i] > A[index] {
            return false
        }
    }
    for i := index+1; i < len(A); i++{
        if A[index] < A[i] {
            return false
        }
    }
    return true
}
func peakIndexInMountainArray(A []int) int {
    for i := 0; i < len(A); i++{
        if v := isPeak(i, A); v {
            return i
        }
    }
    return -1
}
