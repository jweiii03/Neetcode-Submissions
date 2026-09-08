class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int currLeftBound = intervals[i][0];
            int currRightBound = intervals[i][1];

            while (i < intervals.length - 1 && currRightBound >= intervals[i + 1][0]) {
                currRightBound = Math.max(currRightBound, intervals[i+1][1]);
                i++;
            }

            result.add(new int[]{currLeftBound, currRightBound});
        }

        int[][] ans = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
