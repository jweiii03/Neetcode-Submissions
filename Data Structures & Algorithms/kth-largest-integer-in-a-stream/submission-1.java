// Space complexity: O(k), max size of PQ

class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // O(nlogk), where n = array nums length
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                // min heap only need to hold up to k numbers, and peeking the top of pq is kth largest element
                minHeap.poll();
            }
        }
    }
    
    // O(logk)
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
