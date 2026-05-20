// Time Complexity: O(n) - three separate linear passes over the array (prefix max, suffix max, final accumulation)
// Space Complexity: O(n) - two auxiliary arrays (prefixMax, suffixMax) each of size n
class Solution {
    public int trap(int[] height) {
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];
        int pMax = 0, sMax = 0;

        // For each index, record the max height seen so far from the left
        for (int i = 0; i < height.length; i++) {
            pMax = Math.max(pMax, height[i]);
            prefixMax[i] = pMax;
        }

        // For each index, record the max height seen so far from the right
        for (int i = height.length - 1; i >= 0; i--) {
            sMax = Math.max(sMax, height[i]);
            suffixMax[i] = sMax;
        }

        int maxArea = 0;

        // Iterate one unit width at a time
        // The water level at any index is capped by the shorter of the two surrounding walls.
        // Subtracting height[i] gives the actual water units sitting above that bar.
        for (int i = 0; i < height.length; i++) {
            maxArea += Math.min(suffixMax[i], prefixMax[i]) - height[i];
        }

        return maxArea;
    }
}
