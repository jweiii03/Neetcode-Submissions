// Time complexity: O(n!)
// Space complexity: O(n!)

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> perm : perms) {
                for (int i = 0; i <= perm.size(); i++) {
                    List<Integer> newCopy = new ArrayList<>(perm);
                    newCopy.add(i, num); // Insert at every index
                    temp.add(newCopy);
                }
            }
            perms = temp;
        }

        return perms;
    }
}
