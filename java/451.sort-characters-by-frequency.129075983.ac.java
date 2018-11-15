class Solution {
    public String frequencySort(String s) {
        if(s.length() == 0)
            return s;
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
        List<Map.Entry<Character, Integer>> list = 
            new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
           public int compare(Map.Entry o1, Map.Entry o2) {
              return (int)o2.getValue() - (int)o1.getValue();
           } 
        });
        Map<Character, Integer> result = new LinkedHashMap<Character, Integer>();
        for(Map.Entry<Character, Integer> e : list) {
            result.put(e.getKey(), e.getValue());
        }
        StringBuilder sb = new StringBuilder();
        for(char key : result.keySet()) {
            int count = result.get(key);
            while(count-- > 0)
                sb.append(key);
        }
        return sb.toString();
    }
}
