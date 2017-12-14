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
public class UnionIntersection {
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
        void print(){
            ListNode t = head;
            while(t != null) {
                System.out.println(t.val);
                t = t.next;
            }
            System.out.println("");
        }
    }
    public static MyList union(MyList ml1, MyList ml2) {
        MyList ml3 = new MyList();
        for(ListNode t1 = ml1.head; t1 != null; t1 = t1.next) {
            for(ListNode t2 = ml2.head; t2 != null; t2 = t2.next) {
                if(t1.val == t2.val) {
                    ml3.add(t1.val);
                }
            }
        }
        for(ListNode t1 = ml1.head; t1 != null; t1 = t1.next) {
            boolean flag = true;
            for(ListNode t3 = ml3.head; t3 != null; t3 = t3.next) {
                if(t1.val == t3.val) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                ml3.add(t1.val);
        }
        for(ListNode t2 = ml2.head; t2 != null; t2 = t2.next) {
            boolean flag = true;
            for(ListNode t3 = ml3.head; t3 != null; t3 = t3.next) {
                if(t2.val == t3.val) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                ml3.add(t2.val);
        }        
        return ml3;
    }
    public static MyList intersect(MyList ml1, MyList ml2) {
        MyList ml = new MyList();
        for(ListNode t1 = ml1.head; t1 != null; t1 = t1.next) {
            for(ListNode t2 = ml2.head; t2 != null; t2 = t2.next) {
                if(t1.val == t2.val)
                    ml.add(t1.val);
            }
        }
        return ml;
    }
    public static void main(String[] args) {
        MyList ml1 = new MyList();
        ml1.add(10);
        ml1.add(15);
        ml1.add(4);
        ml1.add(20);
        
        ml1.print();
        
        MyList ml2 = new MyList();
        ml2.add(8);
        ml2.add(4);
        ml2.add(2);
        ml2.add(10);
        ml2.print();
        
        MyList ml3 = union(ml1, ml2);
        ml3.print();
        
        MyList ml4 = intersect(ml1, ml2);
        ml4.print();
    }
}
