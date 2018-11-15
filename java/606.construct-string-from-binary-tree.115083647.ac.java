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
    
    public void tree2strHelper(TreeNode t, String[] str) {
        if (t != null) {
            str[0] += t.val;
            if (t.left != null) {
                str[0] += "(";
                tree2strHelper(t.left, str);
                str[0] += ")";
            } 
            if (t.left == null && t.right != null) {
                str[0] += "()";
            } 
            if (t.right != null) {
                str[0] += "(";
                tree2strHelper(t.right, str);
                str[0] += ")";
            }
        }
    }
    
    public String tree2str(TreeNode t) {
        String[] strings = new String[1];
        strings[0] = "";
        tree2strHelper(t,strings);
        return strings[0];
    }
}
