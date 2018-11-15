class Solution {
    public String nextClosestTime(String tim) {
        if(tim.compareTo("00:00") == 0 ||
          tim.compareTo("11:11") == 0 ||
          tim.compareTo("22:22") == 0)
            return tim;
        String[] parts = tim.split(":");
        char[] timeChar = (parts[0]+parts[1]).toCharArray();
        List<Integer> firstHour = new ArrayList<>();
        List<Integer> secondHourOne = new ArrayList<>();
        List<Integer> secondHourTwo = new ArrayList<>();
        List<Integer> firstMin = new ArrayList<>();
        List<Integer> secondMin = new ArrayList<>();
        int i;
        for(i = 0; i < timeChar.length; i++) {
            int v = timeChar[i] - '0';
            if(v >= 0 && v <= 2)
                firstHour.add(v);
            if(v >= 0 && v <= 9)
                secondHourOne.add(v);
            if(v >= 0 && v <= 3)
                secondHourTwo.add(v);
            if(v >= 0 && v <= 5)
                firstMin.add(v);
            if(v >= 0 && v <= 9)
                secondMin.add(v);
        }
        int sample = 1000 * (timeChar[0] - '0') + 100 * (timeChar[1] - '0') 
                        + 10 * (timeChar[2] - '0') + 1 * (timeChar[3] - '0');
        List<Integer> time = new ArrayList<>();
        int myTime;
        int j, k, l, m;
        for(i = 0; i < firstHour.size(); i++) {
            if(firstHour.get(i) != 2) {
                for(j = 0; j < secondHourOne.size(); j++) {
                    for(k = 0; k < firstMin.size(); k++) {
                        for(l = 0; l < secondMin.size(); l++) {                            
                            int t = 1000 * firstHour.get(i) 
                                + 100 * secondHourOne.get(j)
                                + 10 * firstMin.get(k) + 1 * secondMin.get(l);
                            if(t != sample)
                                time.add(t);
                        }
                    }
                }
            } else {
                for(j = 0; j < secondHourTwo.size(); j++) {
                    for(k = 0; k < firstMin.size(); k++) {
                        for(l = 0; l < secondMin.size(); l++) {
                            int t = 1000 * firstHour.get(i) 
                                + 100 * secondHourTwo.get(j)
                                + 10 * firstMin.get(k) + 1 * secondMin.get(l);
                            if(sample != t)
                                time.add(t);
                        }
                    }
                }
            }
        }
        Collections.sort(time);
        if(sample > time.get(time.size() - 1))
            myTime = time.get(0);
        else{
            for(i = 0; i < time.size(); i++) {
                if(sample < time.get(i))
                    break;
            }
            myTime = time.get(i);
        }
        String result = String.valueOf(myTime);
        if(result.length() == 1)
            return "00:0" + result;
        else if(result.length() == 2)
            return "00:" + result;
        else if(result.length() == 3)
            return "0" + result.charAt(0) + ":" + result.charAt(1) + result.charAt(2);
        else
            return result.substring(0,2) + ":" + result.substring(2);
    }
}
