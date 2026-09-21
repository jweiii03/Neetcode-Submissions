class Solution {
    public int characterReplacement(String s, int k) {
        // Key is char, value is frequency
        HashMap<Character, Integer> hm = new HashMap<>();

        int res = 0, l = 0, maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            char currChar = s.charAt(r);
            // Update currChar into hashmap
            hm.put(currChar, hm.getOrDefault(currChar, 0) + 1);

            // Get the max frequency (Just need to compare maxf with frequency of currChar that was just added into hashmap)
            maxf = Math.max(maxf, hm.get(currChar));

            // Shift left pointer if k is not large enough
            while ((r - l + 1) - maxf > k) {
                // In this case, we do not update maxf even if its stale
                // Since res stores the largest valid length found at that point of time, and since
                // the window already extended past that length, it is valid to not update maxf
                // If left pointer shifts during an iteration, that iteration cannot produce a larger res
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(r - l + 1, res);
        }
        return res;
    }
}
