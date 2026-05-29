class MyCalendar {
    List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] meet : calendar) {
            if (startTime < meet[1] && endTime > meet[0]) {
                return false;
            }
        }

        calendar.add(new int[]{startTime, endTime});
        return true;
    }
}

/*
[10, 20]
[10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]

[15, 25]
*/

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */