/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev_l1 = reverse_list(l1);
        ListNode rev_l2 = reverse_list(l2);
        int count = 0;
        ListNode l3 = addTwoLists(rev_l1, rev_l2, count);
        return reverse_list(l3);
    }
    
    public ListNode reverse_list(ListNode cur){
        if (cur == null) return null;
        
        else if(cur.next == null) return cur;
        
        else{
            ListNode back = null;
            ListNode front = cur.next;
            while (cur.next != null){
                cur.next = back;
                back = cur;
                cur = front;
                front = cur.next;
            }
            cur.next = back;
            front = null;
            return cur;
            
        }
    }
    
    public ListNode addTwoLists(ListNode l1, ListNode l2, int count){
        if (l1 != null && l2 != null){
            int sum = l1.val + l2.val + count;
            if (sum >= 10)
                count = 1;
            else
                count = 0;
            ListNode res = new ListNode(sum%10);
            res.next = addTwoLists(l1.next,l2.next,count);
            return res;
        } else if (l1 != null){
            int sum = l1.val + count;
            if (sum >= 10)
                count = 1;
            else
                count = 0;
            ListNode res = new ListNode(sum%10);
            res.next = addTwoLists(l1.next,null,count);
            return res;
        } else if (l2 != null){
            int sum = l2.val + count;
            if (sum >= 10)
                count = 1;
            else
                count = 0;
            ListNode res = new ListNode(sum%10);
            res.next = addTwoLists(null, l2.next, count);
            return res;
        } else {
            if (count == 1){
                ListNode res = new ListNode(count);
                return res;
            }                
            return null;
        }    
    }
}
