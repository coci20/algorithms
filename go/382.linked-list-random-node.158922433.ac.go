/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type Solution struct {
    mappedNodes map[int]int
    size int
}


/** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
func Constructor(head *ListNode) Solution {
    var S Solution
    S.mappedNodes = make(map[int]int)
    rand.Seed(time.Now().Unix())
    i := 0
    for head != nil {
        S.mappedNodes[i] = head.Val
        //fmt.Printf("%d\n", head.Val)
        head = head.Next
        i++
    }
    S.size = i
    return S
}


/** Returns a random node's value. */
func (this *Solution) GetRandom() int {
    n := rand.Int()%this.size
    //fmt.Printf("%d\n", n)
    return this.mappedNodes[n]
}


/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(head);
 * param_1 := obj.GetRandom();
 */
