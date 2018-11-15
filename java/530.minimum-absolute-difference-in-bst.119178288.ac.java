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
    
    public void inOrder(TreeNode root, List<Integer> list, int[] min) {
        if(root != null) {
            inOrder(root.left, list, min);
            list.add(root.val);
            if(list.size() > 1) {
                min[0] = Math.min(min[0], list.get(list.size() - 1) - list.get(list.size() - 2));
            }
            inOrder(root.right, list, min);
        }
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        inOrder(root, list, min);
        return min[0];
    }
}
