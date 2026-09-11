class Solution {
    public int climbStairs(int n) {
        // Bottom up approach
        if (n <= 2) {
            return n;
        }
        // n + 1 as index 0 is included, hence +1 to include n
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
