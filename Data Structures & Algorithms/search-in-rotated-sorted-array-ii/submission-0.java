class Solution {
    public boolean search(int[] nums, int target) {
        // If nums[mid] > nums[right] -> left segment sorted, pivot in right
        // If nums[mid] < nums[left] -> right segment sorted, pivot in left
        // ONE IMPT edge case, since theres duplicates, theres a chance that nums[mid] = nums[left] = nums[right], due to duplicates
        // EG: [1(left), 1 (mid), 3, 1(right)] -> In this case, we just shift left++ and right--

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > nums[r]) {
                // Left half sorted
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] < nums[r]) {
                // Right half sorted
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                // nums[mid] == nums[r], and nums[mid] is not target
                r--;
            }
        }

        return false;
    }
}