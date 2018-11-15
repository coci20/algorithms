/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func Pre(root *TreeNode, a []int) []int {
    if root != nil {
        if root.Left != nil {
            a = Pre(root.Left, a)
        }
        a = append(a, root.Val)
        if root.Right != nil {
            a = Pre(root.Right, a)
        }
    }
    return a
}
func minDiffInBST(root *TreeNode) int {
    var a []int
    a = Pre(root, a)
    MaxInt := 1 << 63 - 1
    for i := 1; i < len(a); i++ {
        if MaxInt > (a[i] - a[i-1]) {
            MaxInt = a[i] - a[i-1]
        }
    }
    return MaxInt
}
