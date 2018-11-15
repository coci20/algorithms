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
    
    public int inOrderSucc(TreeNode root) {
        if(root.right != null)
            return inOrderSucc(root.right);
        return root.val;        
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)    return root;
        
        if(key > root.val)
            root.right = deleteNode(root.right, key);
        else if(key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else {
                root.val = inOrderSucc(root.left);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
