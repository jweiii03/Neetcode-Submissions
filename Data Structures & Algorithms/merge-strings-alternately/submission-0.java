class Solution {
    public String mergeAlternately(String word1, String word2) {
        int ptr1 = 0, ptr2 = 0;
        StringBuilder ans = new StringBuilder();
        while (ptr1 < word1.length() && ptr2 < word2.length()) {
            ans.append(word1.charAt(ptr1));
            ans.append(word2.charAt(ptr2));
            ptr1++;
            ptr2++;
        }

        if (ptr1 < word1.length()) {
            ans.append(word1.substring(ptr1));
        }

        if (ptr2 < word2.length()) {
            ans.append(word2.substring(ptr2));
        }

        return ans.toString();
    }
}