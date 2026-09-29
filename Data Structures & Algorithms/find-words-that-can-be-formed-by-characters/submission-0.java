class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : chars.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        int sum = 0;
        for (String word : words) {
            HashMap<Character, Integer> curr = new HashMap<>(hm);
            boolean isGood = false;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.containsKey(c) && curr.get(c) > 0) {
                    curr.put(c, curr.get(c) - 1);
                } else {
                    break;
                }

                if (i == word.length() - 1) {
                    isGood = true;
                }
            }

            if (isGood) {
                sum += word.length();
            }
        }

        return sum;
    }
}