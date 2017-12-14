/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.linked;


/**
 *
 * @author prasannjitk
 */
public class AddTwoNumbers {
    public ListNode addTwoNums(ListNode l1, ListNode l2){
        ListNode rev_l1 = l1.reverse_list();
        ListNode rev_l2 = l2.reverse_list();
        int count = 0;
        ListNode l3 = addTwoLists(rev_l1, rev_l2, count);
        return l3.reverse_list();
        
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
        }
        else if (l1 != null){
            int sum = l1.val + count;
            if (sum >= 10)
                count = 1;
            else
                count = 0;
            ListNode res = new ListNode(sum%10);
            res.next = addTwoLists(l1.next,null,count);
            return res;
        }        
        else if (l2 != null){
            int sum = l2.val + count;
            if (sum >= 10)
                count = 1;
            else
                count = 0;
            ListNode res = new ListNode(sum%10);
            res.next = addTwoLists(null, l2.next, count);
            return res;
        }        
        else {
            if (count == 1){
                ListNode res = new ListNode(count);
                return res;
            }
            return null;
        }
        
        
    }
    
    public void print_list(ListNode cur){
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    
    public static void main(String args[]){
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        
        AddTwoNumbers s = new AddTwoNumbers();
        s.print_list(s.addTwoNums(l1, l2));
       
    }
}
