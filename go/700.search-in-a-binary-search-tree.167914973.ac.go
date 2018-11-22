/*
 * @lc app=leetcode id=700 lang=golang
 *
 * [700] Search in a Binary Search Tree
 *
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 *
 * algorithms
 * Easy (63.18%)
 * Total Accepted:    24.2K
 * Total Submissions: 38.3K
 * Testcase Example:  '[4,2,7,1,3]\n2'
 *
 * Given the root node of a binary search tree (BST) and a value. You need to
 * find the node in the BST that the node's value equals the given value.
 * Return the subtree rooted with that node. If such node doesn't exist, you
 * should return NULL.
 * 
 * For example, 
 * 
 * 
 * Given the tree:
 * ⁠       4
 * ⁠      / \
 * ⁠     2   7
 * ⁠    / \
 * ⁠   1   3
 * 
 * And the value to search: 2
 * 
 * 
 * You should return this subtree:
 * 
 * 
 * ⁠     2     
 * ⁠    / \   
 * ⁠   1   3
 * 
 * 
 * In the example above, if we want to search the value 5, since there is no
 * node with value 5, we should return NULL.
 * 
 * Note that an empty tree is represented by NULL, therefore you would see the
 * expected output (serialized tree format) as [], not null.
 * 
 */
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
