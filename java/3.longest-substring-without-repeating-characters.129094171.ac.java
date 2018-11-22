class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        int count = 0;
        int idx = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, i);
                count++;
            } else {
                len = Math.max(len, count);
                idx = Math.max(idx, map.get(c));
                count = i - idx;
                len = Math.max(len, count);
                map.put(c, i);
            }
        }
        len = Math.max(len, count);
        return len;
    }
}
