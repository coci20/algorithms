class Solution {
    
    /*
     * determine if the input character is a vowel
     */
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
           || c == 'A' || c == 'E' || c == 'I' || c =='O' || c == 'U')
            return true;
        return false;
    }
    
    /*
     * swap utility function
     */
    public void swap(char[] s, int x, int y) {
        char temp = s[x];
        s[x] = s[y];
        s[y] = temp;
    }
    
    public String reverseVowels(String s) {
        if (s.length() == 0) return s;
        
        //List to store the position of the vowels
        List<Integer> nums = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                nums.add(i);
            }
        }
        
        char[] sa = s.toCharArray();
        
        for (int i = 0; i < (nums.size()/2); i++) {
            swap(sa, nums.get(i), nums.get(nums.size()-1-i));
        }
        return String.valueOf(sa);
    }
}
