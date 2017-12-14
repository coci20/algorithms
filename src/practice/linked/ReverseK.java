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
public class ReverseK {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    static public class MyList {
        ListNode head;
        void add (int n) {
            if(head == null) {
                head = new ListNode(n);
                return;
            }
            ListNode t = head;
            while(t.next != null) {
                t = t.next;
            }
            t.next = new ListNode(n);
        }
        void print() {
            System.out.println("printing the list");
            ListNode t = head;
            while(t != null) {
                System.out.println(t.val);
                t = t.next;
            }
            System.out.println("");
        }        
    }
    public static ListNode reverseK(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode t = head;
        ListNode link = null;
        ListNode prev = null;
        int i = 0;
        while(i < k && t != null) {
            link = t.next;
            t.next = prev;
            prev = t;
            t = link;
            i++;
        }
        
        if(link != null) {
            head.next = reverseK(link, k);
        }
        
        return prev;
    }
    public static void main(String[] args) {
        MyList ml = new MyList();
        for(int i = 1; i < 9; i++)
            ml.add(i);
        ml.print();
        ml.head = reverseK(ml.head, 3);
        ml.print();
    }
}
