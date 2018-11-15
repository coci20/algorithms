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
    
    public void sumOfLeftLeavesHelper(TreeNode root, boolean isLeft, int[] sum) {
        if (root != null) {
            if (root.left == null && root.right == null && isLeft == true) {
                sum[0] += root.val;
            }
            sumOfLeftLeavesHelper(root.left, true, sum);
            sumOfLeftLeavesHelper(root.right, false, sum);
        }
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = new int[1];
        sumOfLeftLeavesHelper(root, false, sum);
        return sum[0];
    }
}
