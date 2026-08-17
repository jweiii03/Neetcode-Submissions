class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        while (r < n) {
            nums[l] = nums[r];
            // Shift right ptr until new unique num
            while (r < n && nums[r] == nums[l]) {
                r++;
            } 
            l++;
        }
        return l;
    }
}