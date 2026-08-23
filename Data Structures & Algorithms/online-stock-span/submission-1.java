class StockSpanner {
    // int[] -> [price, tracker on how many prices this price is greater by]
    Stack<int[]> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        // Pop until top of stack > price
        int totalPopped = 0;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            totalPopped += stack.pop()[1];
        }

        stack.add(new int[]{price, totalPopped + 1});
        return totalPopped + 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */