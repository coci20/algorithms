/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int sizeTree(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + sizeTree(root.left) + sizeTree(root.right);
    }
    
    public boolean isSubTreeHelper(TreeNode s, TreeNode t) {
        if(s == t)
            return true;
        if(s == null || t == null)
            return false;
        if(s.val == t.val && sizeTree(s) == sizeTree(t))
            return isSubTreeHelper(s.left, t.left) && isSubTreeHelper(s.right, t.right);
        else
            return isSubTreeHelper(s.left, t) || isSubTreeHelper(s.right, t);
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null)
            return false;
        if(s == t)
            return true;
        return isSubTreeHelper(s, t);
    }
}
