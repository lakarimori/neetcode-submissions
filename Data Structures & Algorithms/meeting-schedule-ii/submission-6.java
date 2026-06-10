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

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        intervals.sort((a,b) -> Integer.compare(a.start,b.start));
        
        for (Interval interval: intervals) {
            if (!queue.isEmpty() && interval.start >= queue.peek()) {
                queue.poll();    
            }

            queue.add(interval.end);
        }

        return queue.size();
    }
}
