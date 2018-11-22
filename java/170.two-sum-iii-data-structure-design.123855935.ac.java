class TwoSum {

    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!map.containsKey(number)) {
            map.put(number, 1);
        } else {
            int count = map.get(number);
            map.put(number, count+1);
        }            
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        
        for(Integer i : map.keySet()) {
            int key = value - i;
            //1. count(i) > 2, value = 2 * i -> return true
            //2. count(i) == 1, map contains (value-i) -> return true, if value != 2 * i
            if(key == i) {
                if(map.get(i) >= 2)
                    return true;
            } else {
                if(map.containsKey(key))
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
