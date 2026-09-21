class Solution {
    public int maxArea(int[] heights) {
        // Always shift pointer with shorter wall
        int left = 0, right = heights.length - 1;
        int maxWater = Integer.MIN_VALUE;
        while (right > left) {
            maxWater = Math.max(maxWater, Math.min(heights[right], heights[left]) * (right - left));
            int currRight = heights[right], currLeft = heights[left];
            if (currRight > currLeft) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
