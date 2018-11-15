class Solution {
    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < candies.length; i++) {
            if(!map.containsKey(candies[i])) {
                map.put(candies[i], 1);
            } else {
                int count = map.get(candies[i]);
                map.put(candies[i], count);
            }
        }
        
        if(map.size() > candies.length/2)
            return candies.length/2;
        else
            return map.size();            
    }
}
