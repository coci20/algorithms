class Solution {
    public int repeatedStringMatch(String A, String B) {
        String s = "";
        int count = 1;
        s += A;
        while(s.length() < B.length()) {
            s += A;
            count++;
        }
        if(s.contains(B))
            return count;
        if(s.concat(s).contains(B)) {
            if(count == 1)
                return 2;
            else
                return 2 * count - 1;
        }
        return -1;
    }
}
