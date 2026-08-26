class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                List<String> parts = new ArrayList<>();

                while (!stack.peek().equals("[")) {
                    parts.add(stack.pop());
                }
                stack.pop(); // Remove '['

                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty()
                        && Character.isDigit(stack.peek().charAt(0))) {
                    num.append(stack.pop());
                }
                num.reverse();

                StringBuilder curr = new StringBuilder();
                for (int i = parts.size() - 1; i >= 0; i--) {
                    curr.append(parts.get(i));
                }

                String decoded = curr.toString()
                        .repeat(Integer.parseInt(num.toString()));

                stack.push(decoded);
            } else {
                stack.push(String.valueOf(c));
            }
        }

        StringBuilder result = new StringBuilder();
        for (String part : stack) {
            result.append(part);
        }

        return result.toString();
    }
}