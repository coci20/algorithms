class Solution {
    public List<Integer> collectDigits(int num) {
        List<Integer> list = new ArrayList<>();
        while(num > 0) {
            if(num % 10 == 0)
                return new ArrayList<>();
            list.add(num % 10);
            num /= 10;
        }
        return list;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(i % 10 == 0)
                continue;
            List<Integer> sublist = collectDigits(i);
            if(sublist.size() == 0)
                continue;
            boolean flag = true;
            for(Integer n : sublist) {
                if(!(i % n == 0)) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                list.add(i);
        }
        return list;
    }
}
