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
    
    public int getMax(int[] nums, int low, int high) {
        int i = low + 1;
        int index = low;
        int max = nums[low];
        while(i <= high) {
            if(max < nums[i]) {
                max = nums[i];
                index = i;                
            }
            i++;
        }
        return index;
    }
    
    public TreeNode constructTree(int[] nums, int low, int high) {
        if(low > high)  return null;
        
        if(low == high) return new TreeNode(nums[low]);
        
        int max = getMax(nums, low, high);
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructTree(nums, low, max - 1);
        root.right = constructTree(nums, max + 1, high);
        
        return root;        
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)   return null;
        return constructTree(nums, 0, nums.length - 1);
    }
}
