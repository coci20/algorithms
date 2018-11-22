class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        for (int i = 0; i < v1.length; i++)
            s1.push(Integer.valueOf(v1[v1.length - 1 -i]));
        for (int i = 0; i < v2.length; i++)
            s2.push(Integer.valueOf(v2[v2.length - 1 -i]));
        
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int ver1 = s1.pop();
            int ver2 = s2.pop();
            if (ver1 < ver2) return -1;
            if (ver1 > ver2) return 1;
        }
        while (!s1.isEmpty()) {
            int ver = s1.pop();
            if (ver > 0)
            return 1;
        }
        while (!s2.isEmpty()) {
            int ver = s2.pop();
            if (ver > 0)
            return -1;
        }
        return 0; 
    }
}
