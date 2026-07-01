// Time Complexity: O(nlogk), extractMax on PQ of max size of k
// Space Complexity: O(k), minHeap of size k

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // We keep a minHeap of size k, so that when we peek PQ, its would be the kth largest element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
