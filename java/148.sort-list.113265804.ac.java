/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
       
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        
        ListNode l = new ListNode(0);
        ListNode head = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
            
        if (l1 != null) l.next = l1;
        else    l.next = l2;
        
        return head.next;
        
    }        
    
    public ListNode sortList(ListNode head) {
        //handle only more than 1 nodes
        if (head != null && head.next != null) {
            ListNode fast = head;
            ListNode slow = head;
            ListNode prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                fast = fast.next.next;
                slow = slow.next;                
            }
            
            prev.next = null;
            
            ListNode head1 = sortList(head);
            ListNode head2 = sortList(slow);
            head = mergeLists(head1, head2);
        }
        return head;
    }
}
