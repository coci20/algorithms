/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    
    public TreeNode createTree(List<ListNode> list, int low, int high) {
        if(low > high)  return null;
        
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(list.get(mid).val);
        root.left = createTree(list, low, mid - 1);
        root.right = createTree(list, mid + 1, high);
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode hp = head;
        while(hp != null) {
            list.add(hp);
            hp = hp.next;
        }
        return createTree(list, 0, list.size() - 1);
    }
}
