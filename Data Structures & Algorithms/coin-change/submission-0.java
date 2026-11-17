class Solution {
    public int coinChange(int[] coins, int amount) {
        // Bottom-up DP: dp[i] stores the minimum coins needed to make amount i.
        // Compute smaller amounts first so their results can be reused.
        //
        // Time: O(amount * n), where n = coins.length, for each amount, we check every coin
        // Space: O(amount) for the DP array

        // Include indices 0 through amount
        int[] dp = new int[amount + 1];

        // amount + 1 represents "unreachable"
        // any valid solution requires at most amount coins
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }

        // Base case, zero coins are needed to make amount zero
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // Iterate through all coins for each amount
            for (int c : coins) {
                // If current coin is larger than current amount, impossible to make up amount so skip
                if (i >= c) {
                    // 1 + dp[i - c], 1 represents the current coin and we use previous computed dp[i - c] value
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }

        // If the target is unreachable, return -1
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}