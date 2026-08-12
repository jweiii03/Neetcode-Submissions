class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        ArrayList<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Optimisation, since if smallest index i is positive, no way sum = 0
            if (nums[i] > 0) break;

            // Skip duplicate
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;

            // Two pointer per iteration
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    ans.add(new ArrayList<>(List.of(nums[i], nums[l], nums[r])));
                    l++;
                    r--;

                    // Skip duplicates here too 
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                    /*
                    No need to check for duplicates on both side 
                    No while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                    */
                }
            }
        }

        return ans;
    }
}