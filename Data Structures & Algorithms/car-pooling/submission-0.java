class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        HashMap<Integer, Integer> endTime = new HashMap<>(); // key = endTime, value = number of ppl alighting 

        for (int[] trip : trips) {
            minHeap.offer(trip);
        }

        int totalPassengers = 0;
        int currTime = 0;

        while (!minHeap.isEmpty()) {
            int[] currTrip = minHeap.poll();
            int currPassengers = currTrip[0];
            int start = currTrip[1];
            int end = currTrip[2];
            // Check if any passengers are alighting
            for (int i = currTime; i <= start; i++) {
                if (endTime.containsKey(i)) {
                    totalPassengers -= endTime.get(i);
                    endTime.remove(i);
                }
            }

            currTime = start;

            totalPassengers += currPassengers;
            if (totalPassengers > capacity) {
                return false;
            }
            endTime.put(end, endTime.getOrDefault(end, 0) + currPassengers);
        }

        return true;
    }
}