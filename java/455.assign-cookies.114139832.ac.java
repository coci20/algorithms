public class Solution {
    public int findContentChildren(int[] gc, int[] sc) {
        Arrays.sort(gc);
        Arrays.sort(sc);
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < gc.length && j < sc.length) {
            if (gc[i] > sc[j]) j++;
            else {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
}
