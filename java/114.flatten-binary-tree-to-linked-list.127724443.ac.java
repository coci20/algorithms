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
    public TreeNode rightMost(TreeNode root) {
        if(root == null)
            return root;
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        if(root.left != null) {
            TreeNode t = root.right;
            root.right = root.left;
            root.left = null;
            rightMost(root.right).right = t;
            flatten(root.right);
        }
        flatten(root.right);
    }
}
