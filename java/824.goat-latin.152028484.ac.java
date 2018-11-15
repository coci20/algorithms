class Solution {
    public boolean startsWithVowel(String p) {
        return p.charAt(0) == 'a' || p.charAt(0) == 'e' || p.charAt(0) == 'i' || p.charAt(0) == 'o' || p.charAt(0) == 'u' ||
            p.charAt(0) == 'A' || p.charAt(0) == 'E' || p.charAt(0) == 'I' || p.charAt(0) == 'O' || p.charAt(0) == 'U';
    }
    public String toGoatLatin(String S) {
       //break
        String []strs = S.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String b = "";
            if(startsWithVowel(strs[i])) {
                b += strs[i];
            } else {
                b += strs[i].substring(1);
                b += strs[i].charAt(0);
            }
            b += "ma";
            for(int j = 0; j <= i; j++) {
                b += "a";
            }
            list.add(b);
        }
        StringBuilder sb = new StringBuilder();
        for (String m : list) {
            sb.append(m);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
