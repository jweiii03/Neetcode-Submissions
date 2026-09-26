// Time: O(n log n). The loop is O(n) but sort dominate
// Space: O(n)

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int removed = 0;
        // Track the current right boundary to check for overlap with current interval
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) { // overlap
                removed++;
                // Since we need remove one of the two, we remove the larger right boundary to make sure we remove minimum number of intervals
                prevEnd = Math.min(prevEnd, intervals[i][1]); // keep the interval that is ending earlier, greedy solution!
            } else {
                // No overlap, update current right boundary to next interval
                prevEnd = intervals[i][1];
            }
        }
        return removed;
    }
}