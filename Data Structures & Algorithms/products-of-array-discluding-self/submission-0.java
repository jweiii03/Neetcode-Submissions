// Time Complexity: O(n), two passes through array
// Space Complexity: O(1), only use constant space excluding output array

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // O(2n) = O(n) solution, iterate through list once and find product of all int
        // Iterate again, each index -> Sum of produce / Current index no, add to arr

        int product = 1;
        int totalZeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                totalZeroes++;
                continue;
            } 
            product *= nums[i];
        } 
        int[] ans = new int[nums.length];

        if (totalZeroes > 1) {
            return ans; // Guranteed list contains all 0s
        }

        for (int i = 0; i < nums.length; i++) {
            if (totalZeroes > 0) {
                ans[i] = (nums[i] == 0) ? product : 0; 
                // One zero only, index with 0 will have non zero value in ans array
            } else {
                ans[i] = product / nums[i];
                // No zeroes, safely divide
            }
        }
        return ans;

    }
}
