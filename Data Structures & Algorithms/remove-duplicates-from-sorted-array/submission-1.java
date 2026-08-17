// Time complexity: O(n)
// Space complexity: Two pointers, O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        while (r < n) {
            nums[l] = nums[r];
            // Shift right ptr until new unique num is found
            while (r < n && nums[r] == nums[l]) {
                r++;
            } 
            // Shift left ptr to store new found unique num
            l++;
        }
        // Leaves anything from index k onward unspecified
        
        return l;
    }
}