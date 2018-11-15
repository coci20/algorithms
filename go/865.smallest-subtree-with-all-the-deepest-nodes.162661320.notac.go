/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func subTreeHelper(root *TreeNode, m map[*TreeNode]int, max, h int, result *TreeNode) (map[*TreeNode]int, int, int, *TreeNode) {
    if root != nil {
        if root.Left == nil && root.Right == nil {
            m[root] = h
            if max < h {
                max = h
            }
            if m[root] == max {
                result = root
            }
            return m, max, h, result
        }
        d1 := 0
        d2 := 0
        if root.Left != nil {
            m, max, d1, result = subTreeHelper(root.Left, m, max, h+1, result)
        }
        if root.Right != nil {
            m, max, d2, result = subTreeHelper(root.Right, m, max, h+1, result)    
        }
        if d1 > d2 {
            m[root] = d1
        } else {
            m[root] = d2
        }
        if m[root] == max && d1 > 0 && d2 > 0 {
            result = root
        }
    }
    return m, max, h, result
}
func subtreeWithAllDeepest(root *TreeNode) *TreeNode {
    m := make(map[*TreeNode]int)
    var result *TreeNode
    result = root
    h := 0
    max := 0
    m, max, h, result = subTreeHelper(root, m, h, max, result)
    return result
}
