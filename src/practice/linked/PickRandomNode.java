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
public class PickRandomNode {
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
            while(t.next != null) {
                t = t.next;
            }
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
        int size() {
            int count = 0;
            ListNode t = head;
            while(t != null) {
                t = t.next;
                count++;
            }
            return count;
        }
    }
    public static void chosenNode(MyList ml) {
        ListNode t = ml.head;
        if(t == null)
            return;
        int result = t.val;
        int n = ml.size();
        for(int i = 2; t != null; i++) {
            if((int)(Math.random() * n + 1) == 1) {
                result = t.val;
            }
            t = t.next;
        }
        System.out.println("chosen node has value " + result);
    }
    public static void main(String[] args) {
        MyList ml = new MyList();
        ml.add(3);
        ml.add(5);
        ml.add(9);
        ml.add(1);
        ml.add(11);
        ml.add(20);
        
        ml.print();
        chosenNode(ml);
        chosenNode(ml);
        chosenNode(ml);
        chosenNode(ml);
        chosenNode(ml);
        chosenNode(ml);
        chosenNode(ml);
    }
}
