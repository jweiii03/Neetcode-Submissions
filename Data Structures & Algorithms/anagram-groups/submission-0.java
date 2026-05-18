// Time Complexity: O(n * k * log(k)), where n is number of strings and k is length of each string (sorting is O(k * log(k)))
// Space Complexity: O(n * k), hashmap stores all strings

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String s : strs) {
            char[] cArray = s.toCharArray();
            Arrays.sort(cArray);
            String sorted = new String(cArray);
            if (hm.containsKey(sorted)) {
                hm.get(sorted).add(s);
            } else {
                ArrayList<String> a = new ArrayList<>();
                a.add(s);
                hm.put(sorted, a);
            }
        }

        return new ArrayList<>(hm.values());
    }
}
