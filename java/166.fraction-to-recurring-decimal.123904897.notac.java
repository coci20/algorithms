class Solution {
    
    public int compareParts(String s1, String s2) {
        int k = 0;
        while(k < s2.length() && s1.charAt(k) == s2.charAt(k)) k++;
        return k;
    }
    public String getPattern(String s) {
        String[] parts = new String[s.length()];
        for(int i = 0; i < s.length(); i++) {
            parts[i] = s.substring(i);
        }
        Comparator<String> comprtr = 
            (String s1, String s2) -> {
            int i = 0;
            while(i < s1.length() && i < s2.length()) {
                if(s1.charAt(i) == s2.charAt(i))
                    i++;
                else
                    return s1.charAt(i) - s2.charAt(i);
            }
            return s1.charAt(0) - s2.charAt(0);            
        };
        Arrays.sort(parts, comprtr);
        int i = 0, j = 1, max = 0, diff = 0;
        String ans = "";
        while(i < parts.length - 1) {
            int len = compareParts(parts[i], parts[j]);
            max = Math.max(max, len);
            if(len == max) {
                ans = parts[i].length() > parts[j].length() ? 
                    parts[i] : parts[j];
                diff = Math.abs(parts[i].length() - parts[j].length()); 
            }
            i++;
            j++;
        }
        int index = s.indexOf(ans);
        String result = s.substring(index, index + diff);
        if(result.length() == 0)
            return s;
        else
            return s.substring(0,index) + "(" + result + ")";
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator % denominator == 0)
            return String.valueOf(numerator/denominator);
        double n = 1.0;
        double d = 1.0;
        n *= numerator;
        d *= denominator;
        
        String s = String.valueOf(n/d);
        if(s.length() < 17)
            return s; 
        else {
            if(s.contains(".")) {
                String[] parts = s.split("\\.");
                return parts[0] + "." + getPattern(parts[1]);
            }
        } 
        return s;
    }
}
