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
public class IsPalindrome {
    public boolean isMatch(ListNode first, ListNode second){
        if (second != null) {
            if (first.val == second.val)
                return isMatch(first.next,second.next);
            else
                return false;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head){
        if (head == null)   return false;
        else if (head.next == null) return true;
        else {
            ListNode second_head = null;
            boolean isEven = false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null) { 
                fast = fast.next;
                slow = slow.next;
                if (fast.next != null)
                    fast = fast.next;
                else {
                    isEven = true;
                    break;
                }
            }
            if (isEven){
                second_head = slow.reverse_list();
            } else {
                second_head = slow.next.reverse_list();
            }
            if (!isMatch(head,second_head)) return false;
            return true;
        }
    }
    
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.insertList(2);
        l1.insertList(3);
        l1.insertList(2);
        l1.insertList(4);
        
        IsPalindrome isp = new IsPalindrome();
        System.out.println(isp.isPalindrome(l1));
    }
}
