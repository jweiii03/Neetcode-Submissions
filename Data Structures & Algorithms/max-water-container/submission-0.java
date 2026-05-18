// Time Complexity: O(n), two pointer approach, single pass through array
// Space Complexity: O(1), only use constant space for variables

class Solution {
    public int maxArea(int[] heights) {
        // Area = Math.min(left height, right heigh) * width
        // Always shift the shorter height of the two bars -> Explores all meaningful area
        int left = 0, right = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (left < right) {
            int currArea = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, currArea);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
