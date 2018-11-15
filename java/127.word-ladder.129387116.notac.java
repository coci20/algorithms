class Solution {
    
    public boolean matches(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        int[] count = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            count[c - 'a']++;
        }
        for(int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            count[c - 'a']--;
        }
        int c = 0;
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0)
                c++;
        }
        return c == 2 ? true : false;
    }
    public boolean ladderHelper(String beginWord,
                               String endWord,
                               List<String> wordList,
                               int[] count,
                               Map<String, Boolean> visited) {
        if(beginWord.compareTo(endWord) == 0)
            return true;
        visited.put(beginWord, true);
        for(String w : wordList) {
            if(!visited.get(w) && 
               matches(w, beginWord)) {
                visited.put(w, true);
                count[0]++;
                boolean flag = ladderHelper(w, endWord,
                                           wordList,
                                           count,
                                           visited);
                if(!flag) {
                    visited.put(w, false);
                    count[0]--;
                    continue;
                }
                return flag;
            }
        }
        visited.put(beginWord, false);
        return false;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int[] count = new int[1];
        count[0] = 0;
        Map<String, Boolean> map = new HashMap<>();
        for(String w : wordList)
            map.put(w, false);
        boolean exists = ladderHelper(beginWord, endWord,
                    wordList, count, map);
        return exists ? count[0] : 0;
    }
}
