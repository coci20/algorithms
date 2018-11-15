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
    public int height(TreeNode root) {
        if(root == null)    return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
    public void getDiameter(TreeNode root, int[] d) {
        if(root != null) {
            int lh = height(root.left);
            int rh = height(root.right);
            int val = 0;
            if(lh != -1 && rh != -1)    val = lh + rh + 2;
            else if(lh != -1)           val = lh + 1;
            else if(rh != -1)           val = rh + 1;
            if(d[0] < val)
                d[0] = val;
            if(root.left != null)       getDiameter(root.left, d);
            if(root.right != null)      getDiameter(root.right, d);
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[1];
        d[0] = 0;
        getDiameter(root, d);
        return d[0];
    }
}
