class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestSub = 0;
        HashSet<Character> hs = new HashSet<>();
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (hs.contains(currChar)) {
                // Slide window until duplicate character found
                while (s.charAt(left) != currChar) {
                    // Remove characters as we shift left window
                    hs.remove(s.charAt(left));
                    left++;
                }
                // Now s.charAt(left) == currChar
                // Remove it from hashset 
                hs.remove(s.charAt(left));
                left++; // Shift left window once to reach currChar index
            } 
            
            hs.add(currChar);
            // Update longestSub every iteration
            longestSub = Math.max(longestSub, i - left + 1);
        }

        return longestSub;
    }
}
