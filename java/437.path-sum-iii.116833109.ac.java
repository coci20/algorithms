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
    public void rootSum(TreeNode root,
                    int sum, ArrayList<Integer> list,
                    int key, int[] count) {
        if (root != null) {
            if(root.left == null && root.right == null) {
                sum += root.val;
                list.add(sum);
            } else {
                sum += root.val;
                if (sum == key)
                    count[0]++;
                if(root.left != null) {                    
                    rootSum(root.left, sum, list, key, count);
                }
                if(root.right != null) {
                    rootSum(root.right, sum, list, key, count);
                }
            }
        }
    }
    
    public void pathSumHelper(TreeNode root, int sum,
                            int[] count) {
        if(root != null) {
            ArrayList<Integer> sublist =
                new ArrayList<>();
            rootSum(root, 0, sublist, sum, count);
            for(int i = 0; i < sublist.size(); i++) {
                if(sublist.get(i) == sum)
                    count[0]++;
            }
            pathSumHelper(root.left, sum, count);
            pathSumHelper(root.right, sum, count);
        }
    }
    
    public int pathSum(TreeNode root, int sum) {        
        int[] count = new int[1];
        count[0] = 0;
        pathSumHelper(root, sum, count);
        return count[0];
    }
}
