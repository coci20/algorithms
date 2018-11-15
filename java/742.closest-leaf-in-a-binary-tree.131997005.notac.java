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
    public int findClosestLeaf(TreeNode root, int k) {
        if(root.left == null && root.right == null && root.val == k)
            return k;
        Queue<TreeNode> getKey = new LinkedList<>();
        getKey.add(root);
        boolean foundKey = false;
        while(!foundKey) {
            if(getKey.peek().val == k) {
                foundKey = true;
                break;
            }
            TreeNode t = getKey.remove();
            if(t.left != null)
                getKey.add(t.left);
            if(t.right != null)
                getKey.add(t.right);
        }
        TreeNode t = getKey.remove();
        getKey.clear();
        boolean getLeaf = false;
        getKey.add(t);
        int result = k;
        while(!getLeaf) {
            TreeNode temp = getKey.peek();
            if(temp.left == null && temp.right == null) {
                result = temp.val;
                getLeaf = true;
                break;
            }
            temp = getKey.remove();
            if(temp.left != null)
                getKey.add(temp.left);
            if(temp.right != null)
                getKey.add(temp.right);
        }
        getKey.clear();
        return result;
    }
}
