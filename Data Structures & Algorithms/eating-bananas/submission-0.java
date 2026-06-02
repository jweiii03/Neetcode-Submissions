// Time complexity: O(log(m) * n), where m is the largest pile of bananas in list and upper bound of k, where n is the length of list
// Space complexity: O(1)

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Lower bound of k, since if 0 koko will not eat any banana
        int left = 1;
        // Upper bound of k
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right; // Result initially initialised to upper bound of k
        // So if there is no better minimum eating speed, we return the worst minEatingSpeed

        // Perform Binary Search
        while (right >= left) {
            int mid = (left + right) / 2; // Basically the k value
            int totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / mid);
            }

            if (totalTime <= h) {
                result = Math.min(result, mid);
                // Try to find a better minimum eating speed
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
