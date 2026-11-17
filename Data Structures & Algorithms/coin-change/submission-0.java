class Solution {
    public int coinChange(int[] coins, int amount) {
        // Bottom up DP: we find the min number of coins from range 0 to amount
        // Reuse dp values when computing higher dp values

        // +1 as we need to store 0...amount, answer will be dp[amount]
        int[] dp = new int[amount + 1]; 
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        // Base case, 0 coins needed for amount = 0
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // Iterate through all coins
            for (int c : coins) {
                // If current coin is larger than current amount, impossible to make up amount so skip
                if (i >= c) {
                    // 1 + dp[i - c], 1 represents the current coin and we use previous computed dp[i - c] value
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                } 
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
