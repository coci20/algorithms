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
    
    TreeNode sortedArrayHelper(int[] nums, int low, int high) {
        if(low > high)  return null;
        int mid = (low + high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayHelper(nums, low, mid - 1);
        root.right = sortedArrayHelper(nums, mid + 1, high);
        return root;        
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return sortedArrayHelper(nums, 0, nums.length - 1);
    }
}
