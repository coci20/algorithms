class Solution {
    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> comptr = (Integer e1, Integer e2) -> e2 - e1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(comptr);
        for(Integer i : nums) {
            pq.add(i);
        }
        for(int i = 0; i < k-1; i++) {
            pq.remove();
        }
        return pq.peek();
    }
}
