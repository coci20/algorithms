import java.util.Map.Entry;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int i, key;
        for(i = 0; i < nums.length; i++) {
            key = nums[i];
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                int count = map.get(key);
                count++;
                map.put(key, count);                
            }
        }
        /* trying to sort by value */
        Set<Entry<Integer,Integer>> set = map.entrySet();
        
        Comparator<Entry<Integer, Integer>> valueCompare =
            new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
                int v1 = e1.getValue();
                int v2 = e2.getValue();
                return v2 - v1;
            }
        };
        List<Entry<Integer, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, valueCompare);
        LinkedHashMap<Integer, Integer> lhMap = new LinkedHashMap<>(list.size());
        for(Entry<Integer, Integer> e : list) {
            lhMap.put(e.getKey(), e.getValue());
        }
        i = 0;
        for(Integer num : lhMap.keySet()) {
            res.add(num);
            i++;
            if(i == k)
                break;
        }
        return res;
    }
}
