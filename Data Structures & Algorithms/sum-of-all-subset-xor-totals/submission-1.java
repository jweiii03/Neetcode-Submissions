/*
Time: O(n · 2ⁿ)
- Each call corresponds to exactly one subset, and there are 2ⁿ subsets, so there are 2ⁿ calls
- Each call re-XORs the whole subset, which takes up to O(n)
- 2ⁿ calls, one per subset and O(n) work per call -> Total is O(n · 2ⁿ)

Space: O(n)
- The recursion goes at most n levels deep, since each level adds one more element.
*/

class Solution {
    int res;
    public int subsetXORSum(int[] nums) {
        res = 0;
        backtrack(0, nums, new ArrayList<>());
        return res;
    }

    public void backtrack(int i, int[] nums, List<Integer> subset) {
        // calculate curr XOR total of current subset
        int xorr = 0;
        for (int num : subset) {
            xorr ^= num;
        }
        res += xorr;

        for (int j = i; j < nums.length; j++) {
            subset.add(nums[j]);
            backtrack(j + 1, nums, subset);
            subset.remove(subset.size() - 1);
        }
    }
}