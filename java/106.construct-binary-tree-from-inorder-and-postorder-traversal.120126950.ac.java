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
    
    public int getRootIn(int[] in, int low, int high, int key) {
        if(low >= high)
            return -1;
        int i;
        for(i = low; i <= high; i++) {
            if(in[i] == key)
                break;
        }
        return i;
    }
    
    public TreeNode buildTreeHelper(int[] in, int[] post, int[] index,
                                   int low, int high) {
        if(low > high)
            return null;
        
        if(low == high) {
            TreeNode root = new TreeNode(post[index[0]]);
            return root;
        }
        
        TreeNode root = new TreeNode(post[index[0]]);
        int k = getRootIn(in, low, high, root.val);
        if(k < high) {
            index[0]--;
            root.right = buildTreeHelper(in, post, index, k + 1, high);
        }
        if(k > low) {
            index[0]--;
            root.left = buildTreeHelper(in, post, index, low, k - 1);
        }        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] index = new int[1];
        index[0] = postorder.length - 1;
        return buildTreeHelper(inorder, postorder, index, 0, postorder.length - 1);
    }
}
