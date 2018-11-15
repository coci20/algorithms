type Solution struct {
    hasMap map[int][]int
}


func Constructor(nums []int) Solution {
    var S Solution
    rand.Seed(time.Now().Unix())
    S.hasMap = make(map[int][]int)
    for i := 0; i < len(nums); i++{
        k := nums[i]
        S.hasMap[k] = append(S.hasMap[k],i)
    }
    return S
}


func (this *Solution) Pick(target int) int {
    v := this.hasMap[target]
    if len(v) == 1 {
        return this.hasMap[target][0]
    }
    n := rand.Int()%len(v)
    return this.hasMap[target][n]
}


/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.Pick(target);
 */
