class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int count = map.get(c);
                map.put(c, count + 1);
            }
        }
        int len = 0;
        boolean odd = false;
        for(Character c : map.keySet()) {
            int count = map.get(c);
            if(count % 2 == 0)
                len += count;
            else {
                len += count - 1;
                if(!odd)
                    odd = true;
            }
        }
        return odd ? 1 + len : len;
    }
}
