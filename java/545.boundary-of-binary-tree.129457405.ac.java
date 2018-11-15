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
    public void travelLeft(TreeNode root,
                          List<Integer> list) {
        if(root != null) {
            if(!(root.left == null && root.right == null))
                list.add(root.val);
            if(root.left != null)
                travelLeft(root.left, list);
            else if(root.right != null)
                travelLeft(root.right, list);                
        }
    }
    public void getLeaves(TreeNode root,
                         List<Integer> list) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                list.add(root.val);
                return;
            }
            getLeaves(root.left, list);
            getLeaves(root.right, list);
        }
    }
    public void travelRight(TreeNode root,
                           List<Integer> list) {
        if(root != null) {
            if(root.right != null)
                travelRight(root.right, list);
            else if(root.left != null)
                travelRight(root.left, list);
            if(!(root.left == null && root.right == null)) {
                list.add(root.val);
                return;
            }
        }
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if(root.left == null && root.right == null)
            return list;
        travelLeft(root.left, list);
        getLeaves(root, list);
        travelRight(root.right, list);
        return list;
    }
}
