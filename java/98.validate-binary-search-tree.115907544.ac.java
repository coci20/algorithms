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
    
    public void inorderTraverse(TreeNode root, List<Integer> mylist) {
        if (root != null) {
            inorderTraverse(root.left, mylist);
            mylist.add(root.val);
            inorderTraverse(root.right, mylist);
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraverse(root, list);
        boolean flag = true;
        int i = 0;
        for(int j = 1; j < list.size(); j++) {
            if(list.get(i) >= list.get(j))
                return false;
            i++;
        }
        return true;
    }
}
