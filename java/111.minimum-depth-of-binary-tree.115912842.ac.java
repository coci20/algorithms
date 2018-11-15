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
    
    public void findMinDepth(TreeNode root, int[] min, int depth) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                if (depth < min[0])
                    min[0] = depth;
            } else {
                findMinDepth(root.left, min, depth + 1);
                findMinDepth(root.right, min, depth + 1);
            }            
        }
    }
    
    public int minDepth(TreeNode root) {
        if(root == null)    return 0;
        
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        findMinDepth(root, min, 1);
        
        return min[0];
    }
}
