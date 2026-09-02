class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, longestSubString = 0;
        HashSet<Character> hs = new HashSet<>();
        for (int r = 0; r < s.length(); r++) {
            char currChar = s.charAt(r);
            
            while (l < s.length() && hs.contains(currChar)) {
                hs.remove(s.charAt(l));
                l++;
            }

            hs.add(currChar);

            longestSubString = Math.max(longestSubString, hs.size());
        }

        return longestSubString;
    }
}
