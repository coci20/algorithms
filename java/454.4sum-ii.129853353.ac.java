class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int compl = -(A[i] + B[j]);
                if(!map.containsKey(compl)) {
                    map.put(compl, 1);
                } else {
                    int c = map.get(compl);
                    map.put(compl, c + 1);
                }
            }
        }
        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                if(map.containsKey(C[i] + D[j]))
                    count += map.get(C[i] + D[j]);
            }
        }
        return count;
    }
}
