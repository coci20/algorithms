class Solution {
    public String bitPattern(int n, int len) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            if((n & (1 << i)) > 0 )
                sb.append("1");
            else
                sb.append("0");
        }
        return sb.reverse().toString();
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < (int)Math.pow(2, n); i++) {
            list.add(bitPattern(i, n));
        }
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            List<Integer> strList = new ArrayList<>();
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '1')
                    strList.add(nums[j]);
            }
            lists.add(strList);
        }
        return lists;
    }
}
