class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        int left = newInterval[0], right = newInterval[1];

        // 1. Intervals entirely before newInterval
        while (i < n && intervals[i][1] < left) {
            res.add(intervals[i++]);
        }

        // 2. Overlapping intervals: merge into [left, right]
        while (i < n && intervals[i][0] <= right) {
            left = Math.min(left, intervals[i][0]);
            right = Math.max(right, intervals[i][1]);
            i++;
        }
        res.add(new int[]{left, right});

        // 3. Intervals entirely after
        while (i < n) {
            res.add(intervals[i++]);
        }

        // We can do .toArray here bcuz int[] is an object, cannot use .toArray for ArrayList<Integer> -> int[]
        return res.toArray(new int[0][]);
    }
}