class Solution {
    public int characterReplacement(String s, int k) {
        int maxFrequency = 0;
        int l = 0;
        int res = 0;
        HashMap<Character, Integer> counter = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char currChar = s.charAt(r);
            // Add curr Character into hashmap
            counter.put(currChar, counter.getOrDefault(currChar, 0) + 1);

            // After adding curr char into hashmap, check if it is now the largest frequency character in window
            maxFrequency = Math.max(maxFrequency, counter.get(currChar));

            // Loop until window is valid (Valid if window_size - max_frequency <= k)
            while (r - l + 1 - maxFrequency > k) {  // If > k, means more than k characters need to be replaced
                // Update hashmap and shift left pointer
                counter.put(s.charAt(l), counter.get(s.charAt(l)) - 1);
                l++;
            }

            // Update result (Compare with VALID window size)
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
