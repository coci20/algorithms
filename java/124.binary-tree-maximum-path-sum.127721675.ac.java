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
    public int maxPathSumHelper(TreeNode root, int[] max) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null) {
            max[0] = Math.max(max[0], root.val);
            return root.val;
        }
        int sum = root.val;
        int l = maxPathSumHelper(root.left, max);
        int r = maxPathSumHelper(root.right, max);
        
        if(l >= 0 && r >= 0) {
            sum += l + r;
            max[0] = Math.max(max[0], sum);
            return Math.max(root.val + l, root.val + r);
        } else if(l >= 0) {
            sum += l;
            max[0] = Math.max(max[0], sum);
            return root.val + l;
        } else if(r >= 0) {
            sum += r;
            max[0] = Math.max(max[0], sum);
            return root.val + r;
        } else {
            max[0] = Math.max(max[0], sum);
            return root.val;
        }
    }
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, max);
        return max[0];
    }
}
