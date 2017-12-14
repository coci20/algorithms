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
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head){
        if (head == null) return null;
        else if (head.next == null) return head;
        else if (head.next.next == null) return head;
        else {
        
            ListNode odd = head;
            ListNode even = head.next;

            ListNode start = even;

            while (even.next != null){
                odd.next = even.next;
                odd = even.next;
                even.next = odd.next;
                even = odd.next;
                if (even == null)
                    break;
            }
            odd.next = start;
            return head;
        }
    }
    
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.insertList(2);
        l1.insertList(3);
        l1.insertList(4);
        l1.insertList(5);
        l1.insertList(6);
        
        OddEvenLinkedList oell = new OddEvenLinkedList();
        oell.oddEvenList(l1).PrintList();
       
    }
}
