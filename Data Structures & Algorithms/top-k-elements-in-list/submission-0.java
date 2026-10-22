class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(new int[]{entry.getValue(), entry.getKey()});
                continue;
            }

            if (minHeap.peek()[0] < entry.getValue()) {
                minHeap.poll();
                minHeap.offer(new int[]{entry.getValue(), entry.getKey()});
            }
        }

        int[] ans = new int[k];
        ArrayList<int[]> arr = new ArrayList<>(minHeap);
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i)[1];
        }

        return ans;
    }
}
