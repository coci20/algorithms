class Solution {
    public int maximumSwap(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        int copy = num;
        int max = -1, index = 0, max_index = 0;
        while(copy > 0) {
            int i = copy % 10;
            if(max < i) {
                max = i;
                max_index = index;
            }
            list.add(i);
            copy = copy/10;
            index++;
        }        
        if(list.get(list.size() - 1) < list.get(max_index)){
            Collections.swap(list, list.size()-1, max_index);
        }
        index = 0;
        copy = 0;
        while(index < list.size()) {
            copy = 10 * copy + list.get(list.size() - 1- index);
            index++;
        }
        return copy > num ? copy : num;
    }
}
