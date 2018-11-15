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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                if (root.val == sum) return true;
                else
                    return false;
            }
            sum = sum - root.val;
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
        return false;
    }
}
