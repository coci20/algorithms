/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getLength(head *ListNode) int {
    if head == nil {
        return 0
    }
    return 1 + getLength(head.Next)
}
func getNode(head *ListNode, index int) *ListNode {
    if index == 0 {
        return head
    }
    return getNode(head.Next, index-1)
} 
func middleNode(head *ListNode) *ListNode {
    length := getLength(head)
    return getNode(head, length/2)
}
