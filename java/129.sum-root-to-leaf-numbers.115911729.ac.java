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
    
    public void sumNumbersHelper(TreeNode root, List<Integer> list, String str) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                str += String.valueOf(root.val);
                list.add(Integer.valueOf(str));
            }
            str += String.valueOf(root.val);
            sumNumbersHelper(root.left, list, str);
            sumNumbersHelper(root.right, list, str);
        }
    }
    
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        sumNumbersHelper(root, list, "");
        int total = 0;
        for (Integer i: list)
            total += i;
        return total;
    }
}
