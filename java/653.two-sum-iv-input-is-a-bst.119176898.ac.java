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
    
    public void inOrder(TreeNode root, List<Integer> list) {
        if(root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
    
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int i, j;
        i = 0;
        j = list.size() - 1;
        
        while(i < j) {
            int sum = list.get(i) + list.get(j);
            if(sum == k)
                return true;
            else if(sum > k)
                j--;
            else {
                i++;
            }
        }
        return false;
    }
}
