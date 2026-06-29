// Time Complexity: O(logn), perform binary search twice
// Space Complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        // Find the pivot first with binary search
        // Once pivot found, do binary search on either sorted left/right half

        int left = 0, right = nums.length - 1;
        while (right > left) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int pivot = left;
        right = nums.length - 1;
        left = 0;

        if (target >= nums[pivot] && target <= nums[right]) {
            // Means in right sorted half
            left = pivot;
        } else {
            // Left sorted half
            right = pivot - 1;
        }

        while (right >= left) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
