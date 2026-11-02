class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // O(n) solution, keep frequency list that is of size nums.length
        // Each index basically = the frequency of the number
        // So we iterate through the nums list first, and populate our hashmap (Key = num, val = count)
        // Afterwards, populate the list by inserting the nums in corresponding index based on frequency, then iterate from the back of the list to find top k elements

        int[] topKElements = new int[k];
        List<List<Integer>> lis = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            lis.add(new ArrayList<>());
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            lis.get(entry.getValue()).add(entry.getKey());
        }

        int ind = 0;

        for (int i = nums.length; i >= 0; i--) {
            if (k == 0) {
                break;
            }

            List<Integer> currLis = lis.get(i);
            if (currLis.isEmpty()) {
                continue;
            }

            for (int j = 0; j < currLis.size(); j++) {
                topKElements[ind] = currLis.get(j);
                k--;
                ind++;
            }
        }

        return topKElements;
    }
}
