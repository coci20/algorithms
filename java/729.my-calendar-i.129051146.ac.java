class MyCalendar {

    List<int[]> eventList;
    public MyCalendar() {
        eventList = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int[] list = new int[2];
        list[0] = start;
        list[1] = end;
        if(eventList.isEmpty()) {
            eventList.add(list);
            return true;
        }
        boolean flag = true;        
        for(int[] entry : eventList) {
            if(start >= entry[1] || end <= entry[0]) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if(flag)
            eventList.add(list);
        return flag;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
