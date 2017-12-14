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
public class AddNums {
    static public class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    ListNode head1 = null;
    ListNode head2 = null;
    ListNode result = null;
    ListNode createList1(int[] nums) {
        ListNode t = head1;
        for(int i = 0; i < nums.length; i++) {
            if(head1 == null) {
                head1 = new ListNode(nums[i]);
                t = head1;
            } else {
                t.next = new ListNode(nums[i]);
                t = t.next;
            }            
        }
        return head1;
    }
    ListNode createList2(int[] nums) {
        ListNode t = head2;
        for(int i = 0; i < nums.length; i++) {
            if(head2 == null) {
                head2 = new ListNode(nums[i]);
                t = head2;
            } else {
                t.next = new ListNode(nums[i]);
                t = t.next;
            }            
        }
        return head2;
    }
    int length(ListNode head) {
        int count = 0;
        ListNode t = head;
        while(t != null) {
            count++;
            t = t.next;
        }
        return count;
    }
    
    ListNode addAndRecur(ListNode l1, ListNode l2, int[] v) {
        if(l1.next == null && l2.next == null) {
            int sum = l1.val + l2.val;
            if(sum > 9)
                v[0] = 1;
            return new ListNode(sum % 10);
        }
        ListNode curr = addAndRecur(l1.next, l2.next, v);
        int sum = l1.val + l2.val + v[0];
        if(sum > 9)
            v[0] = 1;
        ListNode res = new ListNode(sum % 10);
        res.next = curr;
        return res;
    }
    void printList(ListNode head) {
        ListNode t = head;
        while(t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println("");
    }
    ListNode addLists() { 
        int len1 = length(head1);
        int len2 = length(head2);
        int[] v = new int[1];
        
        if(len1 == len2) {
            System.out.println("yes!");
            result = addAndRecur(head1, head2, v);
            if(v[0] == 1) {
                ListNode one = new ListNode(1);
                one.next = result;
                result = one;
            }
            return result;
        } else {
            int diff = Math.abs(len1 - len2);
            ListNode t = null;
            ListNode dummy = t;
            for(int i = 0; i < diff; i++) {
                if(t == null) {
                    t = new ListNode(0);
                    dummy = t;
                } else {
                    t.next = new ListNode(0);
                    t = t.next;
                }
            }
            if(len1 > len2) {
                t.next = head2;
                head2 = dummy;
                printList(head1);
                printList(head2);
                result = addAndRecur(head1, head2, v);
                if(v[0] == 1) {
                    ListNode one = new ListNode(1);
                    one.next = result;
                    result = one;
                }
            } else {
                t.next = head1;
                head1 = dummy;
                printList(head1);
                printList(head2);
                result = addAndRecur(head1, head2, v);
                if(v[0] == 1) {
                    ListNode one = new ListNode(1);
                    one.next = result;
                    result = one;
                }
            }
            return result;
        }
    }
    void printSum() {
        ListNode t = result;
        while(t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 8, 9};
        int[] nums2 = {4, 6, 9};
        AddNums AN = new AddNums();
        AN.head1 = AN.createList1(nums1);
        AN.head2 = AN.createList2(nums2);
        AN.result = AN.addLists();
        AN.printSum();
    }
}
