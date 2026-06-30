// Time Complexity: O(nlogn), iterate through n number of points and extractMax k times from minHeap of size n
// Space Complexity: O(n) 

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // double[] stores [distance from origin, index]
        // Comparing by first index (Which is the distance from origin)
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(arr -> arr[0]));

        for (int i = 0; i < points.length; i++) {
            double currDist = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            pq.offer(new double[]{currDist, i});
        }

        // Result contain k number of coordinates
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[(int) pq.poll()[1]];
        }

        return result;
    }
}
