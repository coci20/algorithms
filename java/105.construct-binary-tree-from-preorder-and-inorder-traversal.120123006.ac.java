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
    
    public TreeNode buildTreeHelper(int[] pre, int[] in, int[] index,
                                   int low, int high) {
        if(low > high)
            return null;
        
        if(low == high) {
            TreeNode root = new TreeNode(pre[index[0]]);
            return root;
        }
        
        TreeNode root = new TreeNode(pre[index[0]]);
        int k = getRootIn(in, low, high, root.val);
        if(k > low) {
            index[0]++;
            root.left = buildTreeHelper(pre, in, index, low, k - 1);
        }
        if(k < high) {
            index[0]++;
            root.right = buildTreeHelper(pre, in, index, k + 1, high);
        }
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] index = new int[1];
        index[0] = 0;
        return buildTreeHelper(preorder, inorder, index, 0, preorder.length - 1);
    }
}
