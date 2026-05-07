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
