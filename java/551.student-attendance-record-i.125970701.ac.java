class Solution {
    public boolean checkRecord(String s) {
        int abs = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'P')
                continue;
            if(c == 'A') {
                abs++;
                if(abs > 1)
                    return false;                
                continue;
            }
            int lt = 1;
            while(i < s.length() - 1 && s.charAt(i + 1) == 'L') {
                lt++;
                i++;
                if(lt > 2)
                    return false;
            }
        }
        return true;
    }
}
