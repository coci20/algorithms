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
public class ListNode {
    public ListNode next;
    public int val;
    public ListNode(int x){
        val = x;
    }
    
    public void PrintList(){
        ListNode temp = this;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    
    public void insertList(int x){
        ListNode temp = this;
        
        while (temp.next != null)
            temp = temp.next;
        temp.next = new ListNode(x);
    }
    
    public ListNode reverse_list(){
        if (this == null) return null;
        
        else if(this.next == null) return this;
        
        else{
            ListNode cur = this;
            ListNode back = null;
            ListNode front = this.next;
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
}
