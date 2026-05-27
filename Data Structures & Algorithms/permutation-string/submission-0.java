class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Since s1 length is fixed, we can have a fixed-size sliding window over s2
        // Maintain two frequency array, where index is the alphabet index, value is count

        // Edge case, check if s1 length is longer than s2
        if (s1.length() > s2.length())  return false;

        int[] s1count = new int[26]; // 26 unique alphabets
        int[] s2count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i) - 'a']++;
            // Initialise s2count array with sliding window size of s1
            s2count[s2.charAt(i) - 'a']++;
        }

        // If anytime matches == 26, means there is a valid permutation, return true
        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1count[i] == s2count[i])   matches++;
        }

        if (matches == 26) return true;
        int l = 0;

        for (int r = s1.length(); r < s2.length(); r++) {
            // Index of alphabet at left and right end of window
            int right = s2.charAt(r) - 'a';
            int left = s2.charAt(l) - 'a';

            // remove left char from window
            if (s2count[left] == s1count[left]) matches--;
            s2count[left]--;
            if (s2count[left] == s1count[left]) matches++;

            // add right char to window
            if (s2count[right] == s1count[right]) matches--;
            s2count[right]++;
            if (s2count[right] == s1count[right]) matches++;

            // Check if both array are equal and if theres a valid permutation
            if (matches == 26)  return true;
            // Shift left pointer
            l++;
        }

        return false;
    }
}
