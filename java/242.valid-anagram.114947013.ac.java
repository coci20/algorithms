class Solution {
    
    public HashMap<Character, Integer> getMapping(String s){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }
            else{
                int count = map.get(c);
                map.put(c, count+1);
            }
        }
        return map;
    }
    
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() ==0) return true;
        else if (s.length() != t.length()) return false;
        else {
            HashMap<Character, Integer> map1 = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();
            map1 = getMapping(s);
            map2 = getMapping(t);
            for (Character c: map1.keySet()) {
                int ct = map1.get(c);
                if (!map2.containsKey(c) || ct != map2.get(c)) return false;
            }
            return true;
        }
    }
}
