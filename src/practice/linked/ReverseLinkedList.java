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
public class ReverseLinkedList {
    
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode headPtr = head;
        
        ListNode head1 = head;
        ListNode p1 = null;
        
        int i = 1;
        while (i != m) {
            p1 = head1;
            head1 = head1.next;
            i++;
        }
        
        ListNode head2 = head1;
        ListNode p2 = head2.next;
        while (i != n) {
            head2 = p2;
            p2 = head2.next;
            i++;
        }
        
        ListNode pre = null;
        ListNode temp = head1;
        while (temp.next != p2) {
            ListNode temp1 = temp.next;
            temp.next = pre;
            pre = temp;
            temp = temp1;
        }
        temp.next = pre;
        head1.next = p2;
        
        if (p1 != null) {
            p1.next = temp;
        }
        else
            headPtr = temp;
        
        return headPtr;
                
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        for (int i = 2; i <= 14; i++) {
            head.insertList(i);        
        }
        head.PrintList();
        head = reverseBetween(head, 2, 2);
        System.out.println("after doing reverse");
        head.PrintList();
    }
    
       
}
