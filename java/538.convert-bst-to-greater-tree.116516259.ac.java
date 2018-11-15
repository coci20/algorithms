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
    
    public void make_greater_tree(TreeNode root, int[] nums,
                                 int[] index) {
        if (root != null) {
            if (root.left == null && root.right == null ){
                root.val = nums[index[0]++];
            } else {
                make_greater_tree(root.right, nums, index);
                root.val = nums[index[0]++];
                make_greater_tree(root.left, nums, index);
            }
        }
    }
    
    public void create_list(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left == null && root.right == null)
                list.add(root.val);
            else {
                create_list(root.right, list);
                list.add(root.val);
                create_list(root.left, list);
            }
        }
    }        
    
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        
        List<Integer> list = new ArrayList<>();
        create_list(root, list);
        
        int[] nums = new int[list.size()];
        nums[0] = list.get(0);
        
        for(int i = 1; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        int[] index = new int[1];
        index[0] = 0;
        make_greater_tree(root, nums, index);
        return root;
    }
}
