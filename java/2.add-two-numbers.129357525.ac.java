/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode t1 = l1, t2 = l2;
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while(t1 != null && t2 != null) {
            int sum = t1.val + t2.val + carry;
            temp.next = new ListNode(sum % 10);
            if(sum > 9)
                carry = 1;
            else
                carry = 0;
            temp = temp.next;
            t1 = t1.next;
            t2 = t2.next;
        }
        t1 = (t1 == null) ? t2 : t1;
        while(t1 != null) {
            int sum = t1.val + carry;
            temp.next = new ListNode(sum % 10);
            if(sum > 9)
                carry = 1;
            else
                carry = 0;
            temp = temp.next;
            t1 = t1.next;
        }
        if(carry > 0)
            temp.next = new ListNode(carry);
        return result.next;
    }
}
