class Solution {
    public int appendCharacters(String s, String t) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (t.charAt(count) == s.charAt(i)) {
                count++;
            }

            // Optimisation, cut off when all characters found in s
            if (count == t.length()) {
                return 0;
            }
        }

        return t.length() - count;
    }
}