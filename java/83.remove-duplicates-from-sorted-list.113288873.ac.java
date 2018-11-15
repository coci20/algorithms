/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)  return head;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null) {
            while (fast != null && slow.val == fast.val) {
                ListNode temp = fast;
                fast = fast.next;
                slow.next = fast;
                temp = null;
            }
            if (fast != null) {
                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }
}
