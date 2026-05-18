// Time Complexity: O(n), single pass through prices array
// Space Complexity: O(1), only use constant space for variables

class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxProfit = 0;

        while (r < prices.length) {
            int buyPrice = prices[l];
            int sellPrice = prices[r];

            if (sellPrice > buyPrice) {
                maxProfit = Math.max(maxProfit, sellPrice - buyPrice);
            } else {
                l = r; // Shift left to right, buy cheaper buying price
            }
            r++; // Always shift right ptr to avoid left and right being on same index
            // And to continue iterating
        }

        return maxProfit;
    }
}
