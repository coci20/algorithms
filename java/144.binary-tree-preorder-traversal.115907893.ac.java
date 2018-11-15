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
    
    public void preorderTraversalHelper(TreeNode root, List<Integer> mylist) {
        if (root != null) {
            mylist.add(root.val);
            preorderTraversalHelper(root.left, mylist);
            preorderTraversalHelper(root.right, mylist);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> mylist = new ArrayList<>();
        preorderTraversalHelper(root, mylist);
        return mylist;
    }
}
