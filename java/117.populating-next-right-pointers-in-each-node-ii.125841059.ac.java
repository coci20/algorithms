/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connectHelper(TreeLinkNode root, List<TreeLinkNode> list,
                             int level) {
        if(root != null) {
            if(list.size() == level)
                list.add(root);
            else {
                TreeLinkNode n = list.get(level);
                n.next = root;
                list.set(level, root);
            }
            connectHelper(root.left, list, level + 1);
            connectHelper(root.right, list, level + 1);
        } 
    }
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> list = new ArrayList<>();
        connectHelper(root, list, 0);
    }
}
