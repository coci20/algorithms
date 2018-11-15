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
    public void findBottomLeftValueHelper(TreeNode root, int n, int[] max, int[] val) {
        if (root != null) {
            if(root.left == null && root.right == null) {
                if(max[0] < n + 1) {
                    max[0] = n + 1;
                    val[0] = root.val;                    
                }
            } else {
                findBottomLeftValueHelper(root.left, n+1, max, val);
                findBottomLeftValueHelper(root.right, n+1, max, val);
            }
        }
    }
    
    public int findBottomLeftValue(TreeNode root) {
        int[] max = new int[1];
        int[] val = new int[1];
        max[0] = 0;
        findBottomLeftValueHelper(root, 1, max, val);
        return val[0];
    }
}
