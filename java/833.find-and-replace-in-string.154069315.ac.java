class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        
        for(int i = 0; i < indexes.length; i++) {
            map1.put(indexes[i], sources[i]);
            map2.put(indexes[i], targets[i]);
        }
        Arrays.sort(indexes);
        sb.append(S.substring(0, indexes[0]));
        int last = 0;
        for(int i = 0; i < indexes.length; i++) {
            if(i > 0) {
                int l = indexes[i] - last;
                if (l > 0) {
                    sb.append(S.substring(last + 1, indexes[i]));    
                }
            }
            String s = map1.get(indexes[i]);
            String w1 = S.substring(indexes[i], indexes[i] + s.length());
            //System.out.println(w1);
            last = indexes[i] + s.length() - 1;
            if (w1.compareTo(s) == 0) {
                sb.append(map2.get(indexes[i]));
            } else {
                sb.append(w1);
            }
        }
        if (last < S.length()) {
            sb.append(S.substring(last + 1, S.length()));
        }
        return sb.toString();
    }
}
