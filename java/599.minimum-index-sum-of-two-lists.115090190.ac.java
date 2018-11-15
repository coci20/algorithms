class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        HashMap<String, Integer> map3 = new HashMap<String, Integer>();
        
        int n1 = list1.length;
        int n2 = list2.length;
        
        int min = n1 + n2 - 1;
        
        ArrayList<String> res = new ArrayList<>();
        
        for (int i = 0; i < n1; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < n2; i++) {
            map2.put(list2[i], i);
        }        
        
        for (String s: map1.keySet()) {
            if (map2.containsKey(s)) {
                int sum = map1.get(s) + map2.get(s);
                if (sum <= min) {
                    min = sum;
                    map3.put(s, sum);
                }
            }
        }        
        
        for (String s: map3.keySet()) {
            if (map3.get(s) == min) res.add(s);
        }
        
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }
}
