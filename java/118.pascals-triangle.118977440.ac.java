class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> lists = new ArrayList<>();
        if(numRows == 0)    return lists;
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        lists.add(list);
        int i, j, n;
        n = 1;
        while(n < numRows) {
            list = new ArrayList<>();
            list.add(1);
            i = 0;
            j = 1;
            int size = lists.get(lists.size() -1).size();
            while(j < size) {
                list.add(lists.get(lists.size() - 1).get(i) + lists.get(lists.size() - 1).get(j));
                i++;
                j++;
            }
            list.add(1);
            lists.add(list);
            n++;
        }
        return lists;
    }
}
