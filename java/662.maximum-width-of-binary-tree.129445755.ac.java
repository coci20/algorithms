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
    public void populate(TreeNode root,
                         List<List<TreeNode>> lists,
                        int lvl) {
        if(root == null && lvl >= lists.size())
            return;
        List<TreeNode> list;
        if(lvl == lists.size()) {
            list = new ArrayList<>();
            lists.add(list);
        } else {
            list = lists.get(lvl);
        }
        list.add(root);
        if(root == null) {
            populate(root, lists, lvl + 1);
            populate(root, lists, lvl + 1);
        }
        if(root != null)
            populate(root.left, lists, lvl + 1);
        if(root != null)
            populate(root.right, lists, lvl + 1);
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        List<List<TreeNode>> lists = new ArrayList<>();
        populate(root, lists, 0);
        int max = 0;
        for(List<TreeNode> sub : lists) {
            int i = 0;
            int j = sub.size() - 1;
            while(sub.get(i) == null)
                i++;
            while(sub.get(j) == null)
                j--;
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
