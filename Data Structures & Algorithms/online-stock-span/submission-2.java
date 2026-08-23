/*
 * Time Complexity:
 * - Per next() call: O(1) amortized
 * - Worst case for a single call: O(n)
 *
 * Each price is pushed onto the stack once and popped at most once.
 * Therefore, n calls to next() take O(n) total time.
 *
 * Space Complexity: O(n)
 * - In the worst case, prices are strictly decreasing, so all n prices
 *   remain in the stack.
 */

class StockSpanner {

    /*
     * Each array stores:
     * [0] = stock price
     * [1] = span already calculated for that price
     *
     * The stack is monotonically decreasing by price from bottom to top.
     */
    Stack<int[]> stack;

    public StockSpanner() {
        // Initialize an empty stack to store prices and their spans.
        this.stack = new Stack<>();
    }

    public int next(int price) {
        // The current day always contributes 1 to its own span.
        int span = 1;

        /*
         * Remove all previous prices that are less than or equal to the
         * current price because their spans can be merged into the
         * current price's span.
         */
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // Add the popped price's previously calculated span.
            span += stack.pop()[1];
        }

        // Store the current price together with its calculated span.
        stack.push(new int[]{price, span});

        // Return the number of consecutive days with price <= current price.
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */