class Solution {
    class Pair {
        String word;
        int count;
        Pair(String w, int c) {
            word = w;
            count = c;
        }
    }
    public List<String> topKFrequent(String[] input, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<Pair> list = new ArrayList<>();
        for(String w : input) {
            if(!map.containsKey(w)) {
                map.put(w, 1);
            } else {
                int c = map.get(w);
                map.put(w, c + 1);
            }
        }
        for(String key : map.keySet()) {
            Pair p = new Pair(key, map.get(key));
            list.add(p);
        }
        Comparator<Pair> comptr = 
                (Pair p1, Pair p2) -> {
                    if(p1.count == p2.count)
                        return p1.word.compareTo(p2.word);
                    else
                        return p2.count - p1.count;
                };
        Collections.sort(list, comptr);
        for(int i = 0; i < k; i++) {
            result.add(list.get(i).word);
        }
        return result;
    }
}
