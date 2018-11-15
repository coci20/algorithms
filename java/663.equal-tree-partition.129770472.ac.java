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
    public int populateMap(TreeNode root,
                           Map<TreeNode, Integer> map) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                map.put(root, root.val);
                return root.val;
            }
            int sum = root.val;
            int l = 0;
            int r = 0;
            if(root.left != null)
                l = populateMap(root.left, map);
            if(root.right != null)
                r = populateMap(root.right, map);
            sum += l + r;
            map.put(root, sum);
            return sum;
        }
        return 0;
    }
    public boolean checkEqualTree(TreeNode root) {
        if(root == null)
            return false;
        Map<TreeNode, Integer> map = new HashMap<>();
        int sum = populateMap(root, map);
        for(TreeNode n : map.keySet()) {
            if(n != root && 2 * map.get(n) == sum)
                return true;
        }
        return false;
    }
}
