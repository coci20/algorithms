class Solution {
    
    public boolean firstCapital(String word) {        
        
        int i;
        char c = word.charAt(0);
        
        if(!(c >= 'A' && c <= 'Z'))         return false;
        
        for(i = 1; i < word.length(); i++) {
            c = word.charAt(i);
            if(!(c >= 'a' && c <= 'z'))
                return false;
        }
        return true;
    }
    
    public boolean allNotCapitals(String word) {
        int i;
        
        for(i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!(c >= 'a' && c <= 'z'))
                return false;
        }        
        return true;
    }
    
    public boolean allCapitals(String word) {
        int i;
        for(i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!(c >= 'A' && c <= 'Z'))
                return false;
        }
        return true;
    }
    
    public boolean detectCapitalUse(String word) {
        return allCapitals(word) || allNotCapitals(word) || firstCapital(word);
    }
}
