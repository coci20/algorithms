class WordDistance {

    Map<String, Integer> map;
    public WordDistance(String[] words) {
       List<String> list = new ArrayList<>();
        for(String w : words) {
            if(!list.contains(w))
                list.add(w);
        }
        map = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            String w1 = list.get(i);
            for(int j = i + 1; j < list.size(); j++) {
                String w2 = list.get(j);
                int distance = shortestDistance(words, w1, w2);
                map.put(w1+":"+w2, distance);
                map.put(w2+":"+w1, distance);
            }
        }
    }
    
    public int shortestDistance(String[] words, String word1, String word2) {
       int i1 = -1, i2 = -1;
        int minDistance = words.length;
        int currentDistance;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }
    
    public int shortest(String w1, String w2) {
        return map.get(w1+":"+w2);
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
