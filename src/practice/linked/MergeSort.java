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
public class MergeSort {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int v) {
            val = v;
        }
    }
    static public class MyList {
        ListNode head;
        void add(int n) {
            if(head == null) {
                head = new ListNode(n);
                return;
            }
            ListNode t = head;
            while(t.next != null)
                t = t.next;
            t.next = new ListNode(n);
        }
        void print() {
            ListNode t = head;
            while(t != null) {
                System.out.println(t.val);
                t = t.next;
            }
            System.out.println("");
        }
    }
    public static void merge(MyList ml1, MyList ml2, MyList ml3) {
        ListNode t1 = ml1.head;
        ListNode t2 = ml2.head;
        ListNode t = null;
        while(t1 != null && t2 != null) {
            if(t1.val > t2.val) {
                if(t == null) {
                    t = t2;
                    ml3.head = t2;
                    t2 = t2.next;
                    continue;
                } else
                    t.next = t2;
                t2 = t2.next;
            } else {
                if(t == null) {
                    t = t1;
                    ml3.head = t1;
                    t1 = t1.next;
                    continue;
                } else
                    t.next = t1;
                t1 = t1.next;
            }
            t = t.next;
        }
        if(t != null && t1 != null) {
            t.next = t1;
        }
        if(t != null && t2 != null) {
            t.next = t2;
        }
    }
    public static void mergeSort(MyList ml) {
        ListNode t = ml.head;
        if(t == null || t.next == null) {
            return;
        }
        ListNode slow = ml.head;
        ListNode fast = ml.head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null)
            return;
        prev.next = null;
        MyList ml1 = new MyList();
        ml1.head = slow;
        MyList ml2 = new MyList();
        ml2.head = ml.head;
        mergeSort(ml2);
        mergeSort(ml1);
        merge(ml2, ml1, ml);
    }
    public static void main(String[] args) {
        MyList ml = new MyList();
        ml.add(4);
        ml.add(9);
        ml.add(10);
        ml.add(3);
        ml.add(6);
        ml.add(20);
        ml.add(1);
        
        ml.print();
        
        mergeSort(ml);
        System.out.println("after merge-sort");
        ml.print();
    }
}
