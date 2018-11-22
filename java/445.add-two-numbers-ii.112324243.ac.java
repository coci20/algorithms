/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (47.92%)
 * Total Accepted:    69.2K
 * Total Submissions: 144.4K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 * 
 * 
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev_l1 = reverse_list(l1);
        ListNode rev_l2 = reverse_list(l2);
        int count = 0;
        ListNode l3 = addTwoLists(rev_l1, rev_l2, count);
        return reverse_list(l3);
    }
    
    public ListNode reverse_list(ListNode cur){
        if (cur == null) return null;
        
        else if(cur.next == null) return cur;
        
        else{
            ListNode back = null;
            ListNode front = cur.next;
            while (cur.next != null){
                cur.next = back;
                back = cur;
                cur = front;
                front = cur.next;
            }
            cur.next = back;
            front = null;
            return cur;
            
        }
    }
    
    public ListNode addTwoLists(ListNode l1, ListNode l2, int count){
        if (l1 != null && l2 != null){
            int sum = l1.val + l2.val + count;
            if (sum >= 10)
                count = 1;
            else
                count = 0;
            ListNode res = new ListNode(sum%10);
            res.next = addTwoLists(l1.next,l2.next,count);
            return res;
        } else if (l1 != null){
            int sum = l1.val + count;
            if (sum >= 10)
                count = 1;
            else
                count = 0;
            ListNode res = new ListNode(sum%10);
            res.next = addTwoLists(l1.next,null,count);
            return res;
        } else if (l2 != null){
            int sum = l2.val + count;
            if (sum >= 10)
                count = 1;
            else
                count = 0;
            ListNode res = new ListNode(sum%10);
            res.next = addTwoLists(null, l2.next, count);
            return res;
        } else {
            if (count == 1){
                ListNode res = new ListNode(count);
                return res;
            }                
            return null;
        }    
    }
}
