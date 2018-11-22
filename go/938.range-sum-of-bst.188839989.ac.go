/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preOrder(root *TreeNode, cache []int) []int {
    if root != nil {
        if root.Left != nil {
            cache = preOrder(root.Left, cache)
        }
        cache = append(cache, root.Val)
        if root.Right != nil {
            cache = preOrder(root.Right, cache)
        }
    }
    return cache
}
func rangeSumBST(root *TreeNode, L int, R int) int {
    var cache []int
    cache = preOrder(root, cache)
    sum := 0
    var leftIndex, rightIndex int
    for i := 0; i < len(cache); i++{
        if cache[i] == L {
            leftIndex = i
        }
        if cache[i] == R {
            rightIndex = i
            break
        }
    }
    for i := leftIndex; i <= rightIndex; i++{
        sum += cache[i]
    }
    return sum
}
