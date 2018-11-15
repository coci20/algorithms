class Solution {
    public int findComplement(int num) {
        if (num == 0) return 1;
        List<Integer> list = new ArrayList<>();
        int numc = num;
        while (numc > 0) {
            list.add(numc%2);
            numc = numc/2;
        }
        int[] compl = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            compl[i] = (list.get(list.size() - i - 1) == 1) ? 0 : 1;
        }
        int sum = 0;
        for(int i = 0; i < compl.length; i++) {
            sum = sum*2 + compl[i];
        }
        return sum;
    }
}
