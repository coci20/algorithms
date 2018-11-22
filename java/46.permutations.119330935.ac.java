class Solution {
    
    public void permuteHelper(List<List<Integer>> lists,
            List<Integer> list, List<Integer> copy){
        
        if(list.isEmpty()){
            lists.add(copy);            
        } else {       
        
            int i, j, v;
            
            for(i = 0; i < list.size(); i++) {
                List<Integer> temp = new ArrayList<>(copy);
                List<Integer> rest = new ArrayList<>();
                for(j = 0; j < i; j++) {
                    rest.add(list.get(j));
                }
                for(j = i+1; j < list.size(); j++) {
                    rest.add(list.get(j));
                }            
                v = list.get(i);            
                temp.add(v);
                permuteHelper(lists, rest, temp);      
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i;
        for(i = 0; i < nums.length; i++)
            list.add(nums[i]);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> copy = new LinkedList<>();
        permuteHelper(lists, list, copy);
        return lists;
    }
}
