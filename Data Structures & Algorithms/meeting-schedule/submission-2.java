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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return true;
        }
        List<Interval> sortedIntervals = intervals.stream().sorted((a,b) -> a.start - b.start).toList();

        Interval lastInterval = sortedIntervals.get(0);
        for (int i=1; i<sortedIntervals.size(); i++) {
            Interval curr = sortedIntervals.get(i);
            if (curr.start < lastInterval.end) {
                return false;
            }
            lastInterval = curr;
        }

        return true;
    }
}
