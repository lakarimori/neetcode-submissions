/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();

        roomEndTimes.add(intervals.get(0).end);

        for (int i=1; i<intervals.size(); i++) {
            int nextFreeTime = roomEndTimes.peek();

            if (nextFreeTime <= intervals.get(i).start) {
                roomEndTimes.poll();
            }

            roomEndTimes.add(intervals.get(i).end);
        }

        return roomEndTimes.size();
    }
}
