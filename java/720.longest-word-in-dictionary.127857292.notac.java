class Solution {
    class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        String value;
    }
    public void insert(TrieNode T, String w) {            
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
    }
    public boolean found(TrieNode t, String w) {
        int i = 0;
        for(; i < w.length(); i++) {
            if(t.nodes[w.charAt(i) - 'a'] != null) {
                t = t.nodes[w.charAt(i) - 'a'];
            } else
                break;
        }
        if(i == w.length() && t != null && t.value != null && t.value.compareTo(w) == 0)
            return true;
        return false;
    }
    public TrieNode createTrie(String[] words) {
        TrieNode trie = new TrieNode();
        if(words.length == 0)
            return null;
        for(String w : words)
            if(w != null && w.compareTo("") != 0)
                insert(trie, w);
        return trie;
    }
    public boolean search(TrieNode trie, String w) {
        if(trie == null)
            return false;
        for(int i = 0; i < w.length() - 1; i++) {
            if(!found(trie, w.substring(0,i + 1)))
                return false;
        }
        return true;
    }
    
    public String longestWord(String[] words) {
        int len = 0;
        String result = "";
        for(String w1 : words) {
            if(w1.compareTo("") == 0)
                continue;
            if(w1.length() == 1) {
                if(result.length() == 0) {
                    result = w1;
                } else {
                    if(result.length() == 1) {
                        result = result.compareTo(w1) > 0 ? w1 : result;
                    }
                }
                continue;
            }
            String[] parts = new String[words.length - 1];
            int i = 0;
            for(String w2 : words) {
                if(w2.compareTo("") == 0)
                    continue;
                if(w1.compareTo(w2) != 0) {
                    parts[i] = w2;
                    i++;
                }
            }
            TrieNode t = createTrie(parts);
            if(t == null)
                continue;
            if(search(t, w1)) {
                len = Math.max(len, w1.length());
                if(len == w1.length()) {
                    if(result.length() != w1.length())
                        result = w1;
                    else
                        result = result.compareTo(w1) > 0 ? w1 : result;
                }                    
            }
        }
        return result;
    }
}
