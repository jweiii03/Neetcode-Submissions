class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Sliding Window Method
        // Shift right side of window is totalSum of window < target
        // Until sum > target, shift left side of window
        int totalSum = 0, minLen = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            totalSum += nums[r];
            if (totalSum >= target) {
                minLen = Math.min(minLen, r - l + 1);
            }

            while (totalSum - nums[l] >= target) {
                totalSum = totalSum - nums[l];
                l++;
                minLen = Math.min(minLen, r - l + 1);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}