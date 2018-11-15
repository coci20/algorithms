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
    
    public int checkHeight(TreeNode root) {
        if(root == null)        return -1;
        
        int lh = checkHeight(root.left);
        if(lh == Integer.MIN_VALUE)     return Integer.MIN_VALUE;
        
        int rh = checkHeight(root.right);
        if(rh == Integer.MIN_VALUE)     return Integer.MIN_VALUE;
        
        int diff = Math.abs(lh - rh);
        if(diff > 1)
            return Integer.MIN_VALUE;
        else
            return 1 + Math.max(lh, rh);
    }
    
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
}
