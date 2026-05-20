// Time Complexity: O(n) - single pass with two pointers moving toward each other
// Space Complexity: O(1) - no auxiliary arrays, just a few variables
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        // Track the max height seen so far from each side
        int leftMax = height[left];
        int rightMax = height[right];
        int waterStored = 0;

        // Two pointer solution
        while(left < right) {
            if(leftMax < rightMax) {
                // Left wall is the bottleneck, safe to process left side
                left++;
                leftMax = Math.max(leftMax, height[left]);
                // If height[left] < leftMax, the difference is water sitting above this bar
                // If height[left] >= leftMax, this evaluates to 0 (no water)
                waterStored += leftMax - height[left];
            } else {
                // Right wall is the bottleneck, safe to process right side
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterStored += rightMax - height[right];
            }
        }

        return waterStored;
    }
}
