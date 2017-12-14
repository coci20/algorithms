/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.trees;

/**
 *
 * @author prasannjitk
 */
public class Trie {
    
    Trie[] nodes = new Trie[10];
    Trie head = null;
    public void insert(String s) {
        if(s.length() == 0) return;
        if(head == null)
            head = new Trie();
        Trie T = head;
        int n = s.length();
        int i = 0;
        while(i < n) {
            int c = s.charAt(i) - '0';
            if(T.nodes[c] != null) {
                T = T.nodes[c];
                i++;
            } else
                break;            
        }
        
        while(i < n) {
            int c = s.charAt(i) - '0';
            T.nodes[c] = new Trie();
            T = T.nodes[c];
            i++;
        }
    }
    
    public boolean search(String s) {
        int i = 0, n = s.length();
        Trie t = head;
        while (i < n) {
            int c = s.charAt(i) - '0';
            if(t.nodes[c] != null) {
                t = t.nodes[c];
                i++;
            } else
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("6073799246");
        t.insert("4082760924");
        t.insert("1234567890");
        
        System.out.println(t.search("1231231231"));
        System.out.println(t.search("6073799246"));
    }
}
