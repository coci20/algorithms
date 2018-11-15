/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode ne = head.next;
        ListNode cur = head;
        ListNode prev = null;
        while (ne != null) {
            if (cur.val != ne.val) {
                prev = cur;
                cur = ne;
                ne = ne.next;
            } else {
                ne = ne.next;
                while (ne != null && cur.val == ne.val) {
                    ne = ne.next;
                }
                if (prev != null)
                    prev.next = ne;
                else
                    head = ne;
                
                if (ne != null) {                    
                    cur = ne;
                    ne = ne.next;
                } else {
                    return head;
                }
            }
        }
        return head;
    }
}
