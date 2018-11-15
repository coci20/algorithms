/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = 
            new HashMap<>();
        RandomListNode t = head;
        while(t != null) {
            map.put(t, new RandomListNode(t.label));
            t = t.next;
        }
        t = head;
        while(t != null) {
            map.get(t).next = map.get(t.next);
            map.get(t).random = map.get(t.random);
            t = t.next;
        }
        return map.get(head);
    }
}
