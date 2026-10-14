class Solution {
    public int maxSubArray(int[] nums) {
        /*
        Keep a running sum of the best subarray ending at the current index.
        If the running sum before nums[i] is negative, it can only drag down any subarray
        that continues past it, so discard it and start fresh at nums[i].
        Update the global max at every step (handles all-negative arrays).

        EG: -2 1 -3 4 -1 2 1 -5 4
        at 1:  prefix -2 < 0 → reset, cur = 1
        at -3: prefix 1 ≥ 0 → cur = -2
        at 4:  prefix -2 < 0 → reset, cur = 4
        4 -1 2 1 → cur = 6 (best)

        Time complexity: O(n), better than brute force O(n^2) solution where we compute every possible subarray sum
        */

        int runningSum = 0;
        int maxSubarraySum = -Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // Check if runningSum can be safely discarded
            if (runningSum <= 0) {
                runningSum = 0;
            }

            runningSum += nums[i];
            maxSubarraySum = Math.max(maxSubarraySum, runningSum);
        }

        return maxSubarraySum;
    }
}