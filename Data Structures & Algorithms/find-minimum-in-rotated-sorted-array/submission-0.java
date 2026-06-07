class Solution {
    public int findMin(int[] nums) {
        // Array is sorted in ascending order initially, means first element is the smallest
        // Hence we can do O(log n) binary search

        int left = 0, right = nums.length - 1;
        // Binary search
        while (right > left) {
            int mid = (right + left) / 2;

            // Min element must be on the right side of middle if nums[mid] > nums[right]
            if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid; // Else min element on left search space
            }
        }

        return nums[left];
    }
}
