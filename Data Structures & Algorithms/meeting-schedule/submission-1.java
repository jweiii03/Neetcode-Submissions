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
        // Sort by starting time of meetings
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval earlier = intervals.get(i);
            Interval later = intervals.get(i + 1);

            if (earlier.end > later.start) {
                return false;
            }
        }
        return true;
    }
}
