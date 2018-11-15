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
    public void levelOrder(TreeNode root, List<List<Integer>> lists,
            int level) {
        if(root == null)    return;        
        List<Integer> list;
        if(lists.size() == level) {
            list = new ArrayList<>();
            lists.add(list);
        } else
            list = lists.get(level);        
        list.add(root.val);
        levelOrder(root.left, lists, level+1);
        levelOrder(root.right, lists, level+1);        
    }
    public List<Integer> largestValues(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        levelOrder(root, lists, 0);
        List<Integer> result = new ArrayList<>();
        for(List<Integer> sublist : lists) {
            int max = Integer.MIN_VALUE;
            for(Integer i : sublist)
                max = Math.max(i, max);
            result.add(max);
        }
        return result;
    }
}
