// Time Complexity: O(n * m * t), n is len of string, m is no of words, t is max length of any word in wordDict
// Space complexity: O(n), boolean dp array is size = len of string
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Approach: Bottom up DP
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i --) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                } 
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
