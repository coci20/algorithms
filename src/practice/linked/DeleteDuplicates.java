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
public class DeleteDuplicates {
    
    public static ListNode duplicateDelete(ListNode head) {
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
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.insertList(2);
        head.insertList(3);
        head.insertList(3);
        
        head = duplicateDelete(head);
        head.PrintList();
    }
}
