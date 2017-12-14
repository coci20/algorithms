/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.trees;

/**
 *
 * @author pprasank
 */
public class TrieNode {
    TrieNode[] nodes = new TrieNode[127];
    
    public TrieNode() {
        
    }
    
    public void insert(String s){
        TrieNode head = this;
        int i = 0;
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (head.nodes[c] != null) {
                head = head.nodes[c];
                i++;
            }
            else
                break;            
        }
        while (i < n) {
            char c = s.charAt(i);
            head.nodes[c] = new TrieNode();
            head = head.nodes[c];
            i++;
        }
    }
    
    public boolean search(String s) {
        TrieNode head = this;
        int i = 0;
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (head.nodes[c] == null)  return false;
            head = head.nodes[c];
            i++;
        }
        return true;
    }
    
    public static void main(String[] args) {
        TrieNode t = new TrieNode();
        t.insert("a");
        t.insert("abc");
        t.insert("xyz");
        System.out.println(t.search("xyz"));
        System.out.println(t.search("bc"));
        
        int val = 1;
        String s = "" + "" + val;
        s+="->";
        System.out.println(s);
    }
}
