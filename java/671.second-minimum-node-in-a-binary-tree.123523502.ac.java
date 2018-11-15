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
    
    public void findSecondMinimumValueHelper(TreeNode root,
                            int[] mins) {
        if(root != null) {
            mins[0] = Math.min(root.val, mins[0]);
            if(root.val > mins[0]) {
                mins[1] = Math.min(mins[1], root.val);
            }
            findSecondMinimumValueHelper(root.left, mins);
            findSecondMinimumValueHelper(root.right, mins);
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        int[] mins = new int[2];
        mins[0] = Integer.MAX_VALUE;
        mins[1] = Integer.MAX_VALUE;
        mins[0] = Math.min(mins[0], root.val);
        findSecondMinimumValueHelper(root.left, mins);
        findSecondMinimumValueHelper(root.right, mins);
        return mins[1] == Integer.MAX_VALUE ? -1 : mins[1];
    }
}
