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
    
    public void getLeaf(TreeNode root, String s, List<String> list) {
        if (root == null) return;
        else if (root.left == null && root.right == null) {
            String str = s + "" + root.val;
            list.add(str);
        } else if (root.left == null) {
            String str = s + "" + root.val + "->";
            getLeaf(root.right, str, list);
        } else if (root.right == null) {
            String str = s + "" + root.val + "->";
            getLeaf(root.left, str, list);
        } else {
            String str = s + "" + root.val + "->";
            getLeaf(root.left, str, list);
            getLeaf(root.right, str, list);
        }
        return;
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        String str = "";
        getLeaf(root, str, list);
        return list;
    }
}
