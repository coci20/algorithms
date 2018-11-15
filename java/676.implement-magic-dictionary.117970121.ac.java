class MagicDictionary {
    
    MagicDictionary[] nodes = new MagicDictionary[26];
    String s = new String();
    ArrayList<String> list = new ArrayList();

    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        MagicDictionary MD = this;
        
        if(MD == null)
            MD = new MagicDictionary();
        
        int i, index;
        for(String ss : dict) {
            for(i = 0; i < ss.length(); i++) {
                index = ss.charAt(i) - 'a';
                if(MD.nodes[index] != null) {
                    MD = MD.nodes[index];
                } else {
                    break;
                }
            }
            while (i < ss.length()) {
                index = ss.charAt(i) - 'a';
                MD.nodes[index] = new MagicDictionary();
                i++;
                MD = MD.nodes[index];
            }
            MD.s = ss;
            list.add(ss);
        }
    }
    
    public boolean matches(String key, String word) {
        int count = 0;
        
        if(key.length() != word.length())   return false;
        
        for(int i = 0; count < 2 && i < key.length(); i++) {
            if(key.charAt(i) != word.charAt(i)) {
                count++;
                continue;
            }
        }
        
        if(count == 1) return true;
        return false;
            
    }    
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        MagicDictionary MD = this;
        
        /* given the word, find all words present in the dictionary and look if this word matches */
        
        for(String ss: list) {
            if(matches(word, ss))
                return true;
        }
        return false;                
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
