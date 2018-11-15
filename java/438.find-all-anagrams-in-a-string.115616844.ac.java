class Solution {
    
    public boolean isAnagram(String s, String p) {
        if (s.length() != p.length()) return false;
        
        int[]  hash = new int[255];
        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i)]++;            
        }
        
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]--;
            if (hash[s.charAt(i)] < 0) return false;
        }
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        int len1= s.length();
        int len2 = p.length();
        int beginIndex = 0;
        List<Integer> list = new ArrayList<>();
        
        while (beginIndex >= 0 && beginIndex <= (len1 - len2)) {            
            int endIndex = beginIndex + len2;
            String str = s.substring(beginIndex, endIndex);
            if (isAnagram(str, p))
                list.add(beginIndex);
            beginIndex++;
        }
        return list;
    }
}
