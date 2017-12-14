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
public class MergeAlternate {
    static public class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }        
    }
    static public class MyList {
        ListNode head;
        void addNums(int v) {
            if(head == null) {
                head = new ListNode(v);
                return;
            }
            ListNode t = head;
            while(t.next != null)
                t = t.next;
            t.next = new ListNode(v);
        }
        void print() {
            if(head == null)    return;
            ListNode t = head;
            while(t != null) {
                System.out.println(t.val + " ");
                t = t.next;
            }
            System.out.println("");
        }
    }
    
    public static void mergeListAlt(MyList l1, MyList l2) {
        if(l1.head == null) {
            l1.head = l2.head;
            l2.head = null;
            return;
        }
        ListNode t1 = l1.head;
        ListNode t2 = l2.head;
        ListNode temp1, temp2;
        while(t1 != null && t2 != null) {
            temp1 = t1.next;
            t1.next = t2;
            temp2 = t2.next;
            t2.next = temp1;
            t1 = temp1;
            t2 = temp2;
        }
        if(t2 != null)
            l2.head = t2;
    }
    public static void main(String[] args) {
        MyList ml1 = new MyList();
        ml1.addNums(5);
        ml1.addNums(7);
        ml1.addNums(13);
        ml1.addNums(17);
        ml1.addNums(11);
        
        ml1.print();
        
        MyList ml2 = new MyList();
        ml2.addNums(12);
        ml2.addNums(10);
        ml2.addNums(2);
        ml2.addNums(4);
        ml2.addNums(6);
        ml2.addNums(8);
        ml2.addNums(11);
        
        ml2.print();
        
        mergeListAlt(ml1, ml2);
        ml1.print();
        ml2.print();
    }
}
