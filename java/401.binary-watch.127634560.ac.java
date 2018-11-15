class Solution {
    public void bitPattern(int n, int len, int num, List<String> list) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < len; i++) {
            if((n & (1 << i)) > 0) {
                sb.append("1");
                count++;
            }
            else
                sb.append("0");
        }
        if(count == num)
        list.add(sb.reverse().toString());
    }
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < (int)Math.pow(2, 10); i++) {
            bitPattern(i, 10, num, list);
        }
        Map<Integer,Integer> hourMap = new HashMap<>();
        for(int i = 0; i < 4; i++) {
            hourMap.put(i, 1 << i);
        }
        Map<Integer, Integer> minuteMap = new HashMap<>();
        for(int i = 0; i < 6; i++) {
            minuteMap.put(i, 1 << i);
        }
        List<String> times = new ArrayList<>();
        for(String s : list) {
            int hour = 0, min = 0;
            String hr = s.substring(0, 4);
            int sum = 0;
            for(int i = 0; i < hr.length(); i++) {
                sum = sum * 2 + (hr.charAt(i) - '0');
            }
            hour = sum;
            sum = 0;
            String mi = s.substring(4);
            for(int i = 0; i < mi.length(); i++) {
                sum = sum * 2 + (mi.charAt(i) - '0');
            }
            min = sum;
            if(hour >= 0 && hour < 12) {
                if(min < 10) {
                    times.add(String.valueOf(hour) + ":0" + String.valueOf(min));
                } else if(min < 60) {
                    times.add(String.valueOf(hour) + ":" + String.valueOf(min));
                } 
            }
        }
        return times;
    }
}
