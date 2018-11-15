class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] nums = new int[26];
        for(Character ch : tasks) {
            nums[ch - 'A']++;
        }
        Arrays.sort(nums);
        int timer = 0;
        while(nums[25] > 0) {
            int i = 0;
            while(i <= n) {
                if(nums[25] == 0)
                    break;
                if(i < 26 && nums[25 - i] > 0)
                    nums[25 - i]--;
                i++;
                timer++;
            }
            Arrays.sort(nums);
        }
        return timer;
    }
}
