/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)  return head;
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode n = head;
        while (n != null) {
            if (n.val < x) {
                l1.next = n;
                l1 = n;
            } else {
                l2.next = n;
                l2 = n;
            }
            n = n.next;
        }
        l2.next = null;
        l1.next = head2.next;
        return head1.next;
    }
}
