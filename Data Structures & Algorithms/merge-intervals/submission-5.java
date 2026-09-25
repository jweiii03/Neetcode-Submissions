class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort by the left bound
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int currLeftBound = intervals[i][0];
            int currRightBound = intervals[i][1];

            while (i < intervals.length - 1 && currRightBound >= intervals[i + 1][0]) {
                // We must constantly update the currRightBound to prevent edge cases like EG: intervals=[[0,2],[1,4],[3,5]] 
                // If we don't update, currRightBound = 2 which is < 3, will not merge [3,5] interval!
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
