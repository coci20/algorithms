class Solution {
    public boolean match(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }        
        for(int i = 0; i < 26; i++) {
            if(count1[i] != count2[i])
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        List<String> list = new ArrayList<>();
        int l1 = s1.length(), l2 = s2.length();
        for(int i = 0; i <= l2 - l1; i++) {
            list.add(s2.substring(i, i + l1));
        }
        for(String s : list)
            if(match(s1, s))
                return true;
        return false;
    }
}
