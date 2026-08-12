class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty()
                    && stack.peek() > 0
                    && asteroid < 0) {

                int top = stack.peek();

                if (top < -asteroid) {
                    // The previous asteroid is destroyed.
                    stack.pop();
                } else if (top == -asteroid) {
                    // Both asteroids are destroyed.
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // The current asteroid is destroyed.
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        return stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}