class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // double[] stores [distance from origin, index]
        // Comparing by first index (Which is the distance from origin)
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(arr -> arr[0]));

        for (int i = 0; i < points.length; i++) {
            double currDist = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            pq.offer(new double[]{currDist, i});
        }

        int[][] result = new int[k][2];
        for (int j = 0; j < k; j++) {
            int index = (int) pq.poll()[1];
            result[j] = points[index];
        }

        return result;
    }
}
