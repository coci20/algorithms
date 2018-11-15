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
    public TreeNode str2tree(String s) {
        if(s.compareTo("") == 0)
            return null;
        if(!s.contains("("))
            return new TreeNode(Integer.parseInt(s));
        int idx = s.indexOf("(");
        TreeNode root = 
            new TreeNode(Integer.parseInt(s.substring(0, idx)));
        int count = 1;
        int i = idx + 1;
        for(; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')')
                count--;
            if(count == 0)
                break;
        }
        if(count == 0 && i < s.length())
            root.left = str2tree(s.substring(idx + 1, i));
        i++;
        idx = i;
        count = 1;
        for(i = idx + 1; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')')
                count--;
            if(count == 0)
                break;
        }
        if(count == 0)
            root.right = str2tree(s.substring(idx + 1, i));
        return root;
    }
}
