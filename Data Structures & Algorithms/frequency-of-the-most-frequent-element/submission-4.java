class Solution {
    public int maxFrequency(int[] nums, int k) {
        // Operation can only be increment
        // So if array is sorted, then we can just check each index
        // Shift left window only when k is not sufficient to increment
        // left to current index - 1 numbers == current index number

        // Sort the array as CAN CHOOSE ANY INDEX, order does not matter
        // Time complexity: O(nlogn) due to sorting
        // Space complexity: O(n) due to merge sort

        Arrays.sort(nums);
        int currSum = 0;
        int l = 0, highestFrequency = 0;

        for (int r = 0; r < nums.length; r++) {
            int currNum = nums[r];

            while (r > 0 && (currNum * (r - l)) - currSum > k) {
                currSum -= nums[l];
                l++;
            }

            highestFrequency = Math.max(r - l + 1, highestFrequency);
            currSum += currNum;
        }

        return highestFrequency;
    }
}