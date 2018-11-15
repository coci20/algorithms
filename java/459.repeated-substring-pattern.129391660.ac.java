class Solution {
    public boolean repeat(String sub, String inp) {
        if(sub.length() > inp.length())
            return false;
        StringBuilder sb = new StringBuilder(sub);
        while(sb.length() < inp.length()) {
            sb.append(sub);
        }
        return sb.length() == inp.length() && sb.toString().compareTo(inp) == 0;
    }
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() == 0)
            return false;
        if(s.length() == 1)
            return false;
        char c = s.charAt(0);
        int i = 1;
        while(i < s.length()) {
            if(s.charAt(i) == c) {
                if(repeat(s.substring(0, i), s))
                    return true;
            }
            i++;
        }
        return false;
    }
}
