// Time Complexity: O(n), single pass through array
// Space Complexity: O(n), hashset stores up to n unique elements

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for (int num : nums) {
            if (!hs.contains(num))  hs.add(num);
            else {
                return true;
            }
        }
        return false;
    }
}
