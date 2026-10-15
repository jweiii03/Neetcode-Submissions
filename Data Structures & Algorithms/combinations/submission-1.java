// Time complexity: O(k · nᵏ) upper bound
// Space comeplexity: O(k)

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        // Build each combination up one number at a time, starting from an empty   
        // list.
        // At each step, try adding every number from `start` to n, then recurse with
        // start = (number just added) + 1, so numbers are always picked in increasing order.
        // This means [1,2] and [2,1] can't both be produced.
        // Once the list has k numbers, save a copy and return.
        // After recursing, remove the last number (undo) and try the next one.
        //
        // EG: n = 3, k = 2
        // [] → add 1 → [1] → add 2 → [1,2] ✓, undo, add 3 → [1,3] ✓
        //    → add 2 → [2] → add 3 → [2,3] ✓
        //    → add 3 → [3] → nothing left after 3, dead end

        res = new ArrayList<>();
        // Start at 1 as range is [1,n]
        backtrack(1, new ArrayList<>(), n, k);
        return res;
    }

    public void backtrack(int start, List<Integer> combination, int n, int k) {
        if (combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < n + 1; i++) {
            combination.add(i);
            backtrack(i + 1, combination, n, k);
            combination.remove(combination.size() - 1); // Backtrack
        }
    }
}