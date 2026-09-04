class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        ArrayList<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Optimisation, if smallest index number is bigger than zero, sum will not be 0
            if (nums[i] > 0)    break;

            while (i > 0 && i < nums.length && nums[i] == nums[i - 1] ) {
                i++;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (right >= 0 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}