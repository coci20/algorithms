class Solution {
    public boolean wordBreakHelper(Set<String> set,
                                  String s, int start,
                                  Boolean[] prefixes) {
        if(start == s.length())
            return true;
        if(prefixes[start] != null)
            return prefixes[start];
        for(int end = start + 1; end <= s.length(); end++) {
            if(set.contains(s.substring(start, end)) && 
                            wordBreakHelper(set, s, end, prefixes)) {
                    prefixes[start] = true;
                    return true;
            }            
        }
        prefixes[start] = false;
        return prefixes[start];
    }
    public boolean wordBreak(String s, List<String> wordDict) {        
        return wordBreakHelper(new HashSet<>(wordDict), s, 0,
                               new Boolean[s.length()]);
    }    
}
