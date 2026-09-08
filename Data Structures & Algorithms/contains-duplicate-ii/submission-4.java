class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (r > k) {
                hs.remove(nums[l]);
                l++;
            }

            int currNum = nums[r];
            if (hs.contains(currNum)) {
                return true;
            }

            hs.add(currNum);
        }

        return false;
    }
}