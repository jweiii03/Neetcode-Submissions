class Solution {
    public void rotate(int[] nums, int k) {
        // For constant space, we can reverse the nums list (EG: [1,2,3,4,5], k = 2)
        // Reverse to get [5,4,3,2,1], afterwards do two more reverse operations
        // One on subarray [0, k - 1], another on [k, nums.length - 1]
        // Time: O(n), since the total lengths reversed sum to 2n.  
        // Extra space: O(1), since all reversals happen in place.
        k %= nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    public static void reverse(int left, int right, int[] nums) {
        while (right > left) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}