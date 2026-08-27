class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Binary search, left bound = max(weights), right bound = sum(weights)
        int right = 0, left = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        int res = right;

        while (left <= right) {
            int cap = (left + right) / 2;
            if (canShip(weights, days, cap)) {
                res = Math.min(res, cap);
                // Check if can get a SMALLER capacity, since we just got a valid one
                right = cap - 1;
            } else {
                // We need to shift left bound, since we just got a capacity that isnt large enough to < days
                left = cap + 1;
            }
        }

        return res;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int ships = 1, currCap = cap;
        for (int w : weights) {
            // Check if ship can take next weight
            if (currCap - w < 0) {
                // If cannot, new ship needed
                ships++;
                // Check if exceed max no of days
                if (ships > days) {
                    return false; // Capacity not large enough to fall below x days
                }
                currCap = cap;
            }
            currCap -= w;
        }

        return true;
    }
}