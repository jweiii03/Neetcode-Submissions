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