/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode splitParts(ListNode root,
                              ListNode[] part,
                              int idx,
                              int len) {
        if(len == 0) {
            part[idx] = null;
            return root;
        }
        if(root != null) {
            part[idx] = root;
            ListNode t = root;
            ListNode prev = null;
            for(int i = 0; i < len; i++) {
                prev = t;
                t = t.next;
            }
            root = t;
            if(prev != null)
                prev.next = null;
        }
        return root;
    }
    
    public int length(ListNode root) {
        if(root == null)
            return 0;
        ListNode t = root;
        int count = 0;
        while(t != null) {
            count++;
            t = t.next;
        }
        return count;
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = length(root);
        int[] splitLengths = new int[k];
        Arrays.fill(splitLengths, len / k);
        for(int i = 0; i < len % k; i++)
            splitLengths[i] += 1;
        ListNode[] parts = new ListNode[k];
        for(int i = 0; i < k; i++) {
            root = splitParts(root, parts, i, splitLengths[i]);
        }
        return parts;
    }
}
