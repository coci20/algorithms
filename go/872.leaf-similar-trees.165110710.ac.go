/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func getLeaves(root *TreeNode, a []int) []int {
    if root != nil {
        if root.Left == nil && root.Right == nil {
            a = append(a, root.Val)
            return a
        }
        a = getLeaves(root.Left, a)
        a = getLeaves(root.Right, a)
    }
    return a
}
func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {
    var ar1 []int
    var ar2 []int
    ar1 = getLeaves(root1, ar1)
    ar2 = getLeaves(root2, ar2)
    if len(ar1) != len(ar2) {
        return false
    }
    //sort.Ints(ar1)
    //sort.Ints(ar2)
    for i := 0; i < len(ar1); i++{
        if ar1[i] != ar2[i] {
            return false
        }
    }
    return true
}
