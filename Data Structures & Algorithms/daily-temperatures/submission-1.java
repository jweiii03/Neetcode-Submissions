// Time Complexity: O(n), each element pushed and popped from stack once
// Space Complexity: O(n), stack can store up to n elements in worst case

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        // int[] contains [value, index]
        Stack<int[]> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currTemp = temperatures[i];

            while (!stack.isEmpty() && stack.peek()[0] <= currTemp) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek()[1] - i;
            }

            stack.push(new int[]{currTemp, i});
        }

        return res;
    }
}
