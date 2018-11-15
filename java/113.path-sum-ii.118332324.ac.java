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
    
    public void sumToLeaf(TreeNode root, String s, List<String> list) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                s += " " + root.val;
                list.add(s);
            } else {
                s += " " + root.val;
                sumToLeaf(root.left, s, list);
                sumToLeaf(root.right, s, list);
            }            
        }
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<String> list = new ArrayList<>();
        sumToLeaf(root, "", list);
        List<List<Integer>> lists = new ArrayList<>();
        for(String ss: list) {
            String[] arr = ss.split(" ");
            List<Integer> t = new ArrayList<>();
            int temp = 0;
            for(String s: arr){
                String sb = s.replaceAll(" ", "");
                if(sb.compareTo("") != 0) {
                    int i = Integer.parseInt(sb);
                    temp += i;
                    t.add(i);
                }
            }
            if(temp == sum)
            lists.add(t);
        }
        return lists;
    }
}
