class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hm.containsKey(diff)){
                ans[0] = hm.get(diff);
                ans[1] = i;
            }

            hm.put(nums[i], i);
        }

        return ans;
    }
}
