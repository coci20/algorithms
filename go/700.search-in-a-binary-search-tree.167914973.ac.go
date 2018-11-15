/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func bstHelper(root *TreeNode, val, min, max int) *TreeNode {
    if root != nil {
        if root.Val == val{
            return root
        } else if val < min || val > max{
            return nil
        } else if root.Val < val{
            return bstHelper(root.Right, val, root.Val, max)
        } else {
            return bstHelper(root.Left, val, min, root.Val)
        }
    }
    return nil
}
func findMin(root *TreeNode) int {
    if root != nil {
        if root.Left != nil {
            return findMin(root.Left)
        } else {
            return root.Val
        }
    }
    return -1
}
func findMax(root *TreeNode) int {
    if root != nil {
        if root.Right != nil {
            return findMax(root.Right)
        } else {
            return root.Val
        }
    }
    return -1
}
func searchBST(root *TreeNode, val int) *TreeNode {
    if root == nil {
        return nil
    }
    min := findMin(root)
    max := findMax(root)
    return bstHelper(root, val, min, max)
}
