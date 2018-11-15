/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode head_ptr = head;
            ListNode front = head.next;
            ListNode back = head;
            while (front != null){
                ListNode itr = head_ptr;
                ListNode prev = null;
                ListNode n = front.next;
                while (front.val >= itr.val && front != itr) {
                    prev = itr;
                    itr = itr.next;
                }
                if (front != itr) {
                    ListNode temp = front;
                    back.next = front.next;
                    if (prev == null) { //insert at the head     
                        temp.next = itr;
                        head_ptr = temp;
                    } else {
                        temp.next = prev.next;
                        prev.next = temp;
                    }
                } else {
                    back = back.next;
                }                
                front = n;
            }
            return head_ptr;
        }
        return head;               
    }
}
