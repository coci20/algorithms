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
public class LinkLoop {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int v) {
            val = v;
        }
    }
    static public class MyList {
        ListNode head;
        void add(int num) {
            if(head == null) {
                head = new ListNode(num);
                return;
            }
            ListNode t = head;
            while(t.next != null)
                t = t.next;
            t.next = new ListNode(num);
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
    public static void addLoop(MyList ml) {
        ListNode t = ml.head;
        while(t.next != null)
            t = t.next;
        ListNode t1 = ml.head;
        for(int i = 0; i < 1; i++)
            t1 = t1.next;
        t.next = t1;
        System.out.println("next of " + t.val + " is now " + t1.val);
    }
    public static boolean checkLoop(MyList ml) {
        ListNode slow = ml.head;
        ListNode fast = ml.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast != null && slow == fast) {
                System.out.println("Loop exists!");
                return true;
            }
        }
        System.out.println("Loop doesn't exist");
        return false;
    }
    public static void breakLoop(MyList ml) {
        ListNode slow = ml.head;
        ListNode fast = ml.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast != null && fast == slow)
                break;
        }
        if(fast != null)
            slow = ml.head;
        ListNode prev = null;
        while(slow != null && fast != null && slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        if(slow != null)
            System.out.println("loop exists at " + slow.val);
        if(prev != null)
            prev.next = null;
    }
    public static void main(String[] args) {
        MyList ml = new MyList();
        ml.add(1);
        ml.add(2);
        ml.add(3);
        ml.add(4);
        ml.add(5);

        ml.print();

        addLoop(ml);
        if(checkLoop(ml)) {
            breakLoop(ml);
            ml.print();
        }
    }    
}
