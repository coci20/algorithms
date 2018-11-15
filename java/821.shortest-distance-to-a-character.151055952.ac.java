class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C)
                list.add(i);
        }
        int prev = -1;
        int next = 0;
        int[] result = new int[S.length()];
        for(int i = 0; i < S.length();) {
            while(next < list.size() && i <= list.get(next)) {
                if(prev >= 0) {
                    result[i] = Math.min(list.get(next) - i, i - list.get(prev));
                } else {
                    result[i] = list.get(next) - i;
                }
                i++;
            }
            if(next < list.size()) {
                prev = next;
                next++;
            } else {
                while(i < S.length()) {
                    result[i] = i - list.get(prev);
                    i++;
                }
            }
        }
        return result;
    }
}
