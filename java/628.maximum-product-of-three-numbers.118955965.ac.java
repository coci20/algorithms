class Solution {
    public int maximumProduct(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        
        if(list.get(0) >= 0) 
            return (list.get(list.size() - 1) * list.get(list.size() - 2) * list.get(list.size() - 3));
        else if (list.get(list.size() - 1) < 0)   
            return (list.get(0) * list.get(1) * list.get(2));
        else {
            int sum1 = list.get(0) * list.get(1);
            int sum2 = list.get(list.size() - 2) * list.get(list.size() - 3);
            return sum1 > sum2 ? (list.get(list.size() - 1) * sum1) : (list.get(list.size() - 1) * sum2);                
        }
    }
}
