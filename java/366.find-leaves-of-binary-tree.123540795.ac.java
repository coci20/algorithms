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
    
    public TreeNode deleteLeaves(TreeNode root, TreeNode n) {
        if(root == null || root == n)
            return null;
        root.left = deleteLeaves(root.left, n);
        root.right = deleteLeaves(root.right, n);
        return root;
    }
    public void addLeaves(TreeNode root, List<TreeNode> leaves) {
        if(root != null) {
            if(root.left == null && root.right == null)
                leaves.add(root);
            else{
                addLeaves(root.left, leaves);
                addLeaves(root.right, leaves);
            }
        }
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        while(root != null) {
            List<TreeNode> leaves = new ArrayList<TreeNode>();
            addLeaves(root, leaves);
            List<Integer> list = new ArrayList<>();
            for(TreeNode n : leaves)
                list.add(n.val);
            lists.add(list);
            for(TreeNode n : leaves) {
                root = deleteLeaves(root, n);
            }
        }
        return lists;
    }
}
