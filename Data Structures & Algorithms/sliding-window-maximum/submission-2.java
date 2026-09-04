class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Stores index, head of deque will store max at all times
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // Check if head of deque is within window index
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            int currNum = nums[i];
            // pop from the back if currNum > nums[dq.removeLast()]
            while (!dq.isEmpty() && currNum > nums[dq.peekLast()]) {
                dq.removeLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                ans[i + 1 - k] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}
