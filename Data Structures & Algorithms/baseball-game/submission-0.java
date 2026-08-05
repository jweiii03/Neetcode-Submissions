class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
}