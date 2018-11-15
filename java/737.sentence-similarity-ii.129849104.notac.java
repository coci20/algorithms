class Solution {
    
    public void populateMap(String[][] pairs,
                           Map<String, List<String>> map) {
        for(String[] p : pairs) {
            if(!map.containsKey(p[0]) && !map.containsKey(p[1])) {
                List<String> list = Arrays.asList(p[0], p[1]);
                map.put(p[0], new ArrayList<>(list));
                map.put(p[1], new ArrayList<>(list));
            } else if(map.containsKey(p[0]) && !map.containsKey(p[1])) {
                for(String ss : map.get(p[0])) {
                    if(ss.compareTo(p[0]) == 0)
                        continue;
                    map.get(ss).add(p[1]);
                }
                map.get(p[0]).add(p[1]);
                map.put(p[1], new ArrayList<>(map.get(p[0])));
            } else if(map.containsKey(p[1]) && !map.containsKey(p[0])) {
                for(String ss : map.get(p[1])) {
                    if(ss.compareTo(p[1]) == 0)
                        continue;
                    map.get(ss).add(p[0]);
                }
                map.get(p[1]).add(p[0]);
                map.put(p[0], new ArrayList<>(map.get(p[1])));
            }
        }
    }
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length)
            return false;
        if(pairs.length == 0) {
            for(int i = 0; i < words1.length; i++) {
                if(words1[i].compareTo(words2[i]) == 0)
                    continue;
                return false;
            }
            return true;
        }
        Map<String, List<String>> map = new HashMap<>();
        populateMap(pairs, map);
        for(int i = 0; i < words1.length; i++) {
            if(words1[i].compareTo(words2[i]) == 0)
                continue;
            if(!map.containsKey(words1[i]) || !map.containsKey(words2[i]))
                return false;
            else {
                boolean matches = false;
                for(String ss : map.get(words1[i])) {
                    if(ss.compareTo(words2[i]) == 0) {
                        matches = true;
                        break;
                    }
                }
                if(matches)
                    continue;
            }
            return false;
        }
        return true;
    }
}
