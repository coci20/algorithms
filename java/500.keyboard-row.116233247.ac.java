class Solution {
    public String[] findWords(String[] words) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        
        set1.add('q');
        set1.add('w');
        set1.add('e');
        set1.add('r');
        set1.add('t');
        set1.add('p');
        set1.add('o');
        set1.add('i');
        set1.add('u');
        set1.add('y');
        
        set2.add('a');
        set2.add('s');
        set2.add('d');
        set2.add('f');
        set2.add('g');
        set2.add('l');
        set2.add('k');
        set2.add('j');
        set2.add('h');
        
        set3.add('z');
        set3.add('x');
        set3.add('c');
        set3.add('v');
        set3.add('b');
        set3.add('n');
        set3.add('m');
        
        List<String> list = new ArrayList<>();
        
        for(String w1 : words) {
            int count = 1;
            String w = w1.toLowerCase();
            char c = w.charAt(0);
            if(set1.contains(c)) {
                for(int i = 1; i < w.length(); i++) {
                    if(set1.contains(w.charAt(i)))
                        count++;
                }
            } else if(set2.contains(c)) {
                for(int i = 1; i < w.length(); i++) {
                    if(set2.contains(w.charAt(i)))
                        count++;
                }
            } else {
                for(int i = 1; i < w.length(); i++) {
                    if(set3.contains(w.charAt(i)))
                        count++;
                }
            }
            if (count == w.length()){
                list.add(w1);
            } 
        }
        
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
