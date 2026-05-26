class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        // Sort pairs by shortest distance away from destination
        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < pair.length; i++) {
            double time = (double) (target - pair[i][0]) / pair[i][1];

            // Check if current car's time is less than or equal to the time of previous car
            // If true, means current car will catch up to the car infront, becomes one car fleet and do not need to push onto stack
            if (stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
            } 
        }

        return stack.size();
    }
}
