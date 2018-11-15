class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length <= 1)
            return pairs.length;
        Comparator<int[]> comptr = (int[] a1, int[] a2) -> a1[1] - a2[1];
        Arrays.sort(pairs, comptr);
        int end = pairs[0][1];
        int res = 1;
        for(int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] > end) {
                res++;
                end = pairs[i][1];
            }
        }
        return res;
    }
}
