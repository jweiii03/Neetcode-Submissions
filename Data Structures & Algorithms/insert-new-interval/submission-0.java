class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        if (n == 0) {
            return new int[][] { newInterval };
        }

        // Find the first interval whose start >= newInterval's start
        int low = 0;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (intervals[mid][0] < newInterval[0]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int position = low;
        int left = position;
        int start = newInterval[0];
        int end = newInterval[1];

        // Only the closest interval on the left can overlap
        if (left > 0 && intervals[left - 1][1] >= start) {
            left--;
            start = intervals[left][0];
            end = Math.max(end, intervals[left][1]);
        }

        // Find the first interval on the right that does not overlap
        int right = position;

        while (right < n && intervals[right][0] <= end) {
            end = Math.max(end, intervals[right][1]);
            right++;
        }

        // Prefix + merged interval + suffix
        int resultSize = left + 1 + (n - right);
        int[][] result = new int[resultSize][2];

        int index = 0;

        // Copy unaffected intervals before the merged range
        for (int i = 0; i < left; i++) {
            result[index++] = intervals[i];
        }

        // Add the merged interval
        result[index++] = new int[] { start, end };

        // Copy unaffected intervals after the merged range
        for (int i = right; i < n; i++) {
            result[index++] = intervals[i];
        }

        return result;
    }
}
