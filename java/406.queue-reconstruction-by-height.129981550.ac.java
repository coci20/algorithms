class Solution {
    public int[][] reconstructQueue(int[][] people) {
       if(people == null || people.length == 0 || people.length == 1)
           return people;
        Comparator<int[]> comptr = (int[] a, int[] b) -> {
            return a[0] != b[0] ? -a[0] + b[0] : a[1] - b[1];
        };
        Arrays.sort(people, comptr);
        List<int[]> list = new LinkedList<>();
        for(int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][]);
    }
}
