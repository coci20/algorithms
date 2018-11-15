class Solution {
    public String bitPattern(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 31; i++) {
            if((num & (1 << i)) > 0)
                sb.append("1");
            else
                sb.append("0");
        }
        return sb.reverse().toString();        
    }
    public int findMaximumXOR(int[] nums) {
        if(nums.length == 1)
            return 0;
        Map<Integer,String> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],bitPattern(nums[i]));
        }
        Set<Integer> list = new HashSet<>();
        boolean found = false;
        for(int i = 0; i < 31; i++) {
            for(Integer key : map.keySet()) {
                if(map.get(key).charAt(i) == '1') {
                    list.add(key);
                    found = true;
                }
            }
            if(found)
                break;
        }
        int max = Integer.MIN_VALUE;
        for(Integer el : list) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != el)
                    max = Math.max(max, el ^ nums[i]);
            }
        }
        return max;
    }
}
