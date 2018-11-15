/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        postorder(root, new HashMap<>(), result);
        return result;
    }
    
    public String postorder(TreeNode current, HashMap<String, Integer> map, List<TreeNode> result){
        if (current == null)    return "#";
        String str = current.val + "," + postorder(current.left,map,result) + "," + postorder(current.right,map,result);
        if (map.getOrDefault(str, 0) == 1)  result.add(current);
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }
}
