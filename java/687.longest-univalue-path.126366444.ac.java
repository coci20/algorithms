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
    public int longestHelper(TreeNode root, int[] max) {
        if(root == null)
            return 0;
        int len1 = longestHelper(root.left, max);
        int len2 = longestHelper(root.right, max);
        int l1 = 0, l2 = 0;
        if(root.left != null && root.left.val == root.val)
            l1 = 1 + len1;
        if(root.right != null && root.right.val == root.val)
            l2 = 1 + len2;
        max[0] = Math.max(max[0], l1 + l2);
        return Math.max(l1, l2);
    }
    public int longestUnivaluePath(TreeNode root) {
        int[] max = new int[1];
        longestHelper(root, max);
        return max[0];
    }
}
