/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

/**
 *
 * @author prasannjitk
 */
public class LongestWord {
    public class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        String value;
        void insert(String w) {
            TrieNode T = this;
            int i = 0;
            for(; i < w.length(); i++) {
                if(T.nodes[w.charAt(i) - 'a'] != null)
                    T = T.nodes[w.charAt(i) - 'a'];
                else
                    break;
            }
            while(i < w.length()) {
                T.nodes[w.charAt(i) - 'a'] = new TrieNode();
                T = T.nodes[w.charAt(i) - 'a'];
                i++;
            }
            T.value = w;
            //System.out.println("inserted " + T.value);
        }
        boolean found(String w) {
            TrieNode t = this;
            System.out.println("looking for " + w);
            int i = 0;
            for(; i < w.length(); i++) {
                if(t.nodes[w.charAt(i) - 'a'] != null) {
                    t = t.nodes[w.charAt(i) - 'a'];
                } else
                    break;
            }
            if(i == w.length() && t != null && t.value.compareTo(w) == 0)
                return true;
            return false;
        }
    }
    public TrieNode createTrie(String[] words) {
        TrieNode trie = new TrieNode();
        for(String w : words)
            if(w.compareTo("") != 0)
                trie.insert(w);
        return trie;
    }
    public boolean search(TrieNode trie, String w) {
        for(int i = 1; i < w.length(); i++) {
            if(!trie.found(w.substring(0,i)))
                return false;
        }
        return true;
    }
    public String longestWord(String[] words) {
        int len = 0;
        String result = "";
        for(String w1 : words) {
            String[] parts = new String[words.length - 1];
            int i = 0;
            for(String w2 : words) {
                if(w1.compareTo(w2) != 0) {
                    parts[i] = w2;
                    i++;
                }
            }
            TrieNode t = createTrie(parts);
            System.out.println("trie created!! for " + w1);
            if(search(t, w1)) {
                System.out.println("found something!");
                len = Math.max(len, w1.length());
                if(len == w1.length())
                    result = w1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        LongestWord LW = new LongestWord();
        System.out.println(LW.longestWord(words));
    }
}
