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
    public void levelOrderList(TreeNode root, List<List<Integer>> lists,
                              int level) {
        if(root == null)    return;
        
        List<Integer> list;
        if(lists.size() == level) {
            list = new ArrayList<>();
            lists.add(list);
        } else
            list = lists.get(level);
        
        list.add(root.val);
        levelOrderList(root.left, lists, level+1);
        levelOrderList(root.right, lists, level+1);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        levelOrderList(root, lists, 0);
        Collections.reverse(lists);
        return (lists);
    }
}
