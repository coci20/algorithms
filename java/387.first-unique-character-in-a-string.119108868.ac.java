class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i, pos;
        char c;
        for(i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int count = map.get(c);
                map.put(c, count + 1);
            }
        }
        
        pos = -1;
        for(i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(map.get(c) == 1) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
