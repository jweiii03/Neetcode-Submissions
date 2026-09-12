class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        // int[] -> enqueueTime, processingTime, i
        int[][] t = new int[n][3];
        for (int i = 0; i < n; i++) {
            t[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(t, (a, b) -> Integer.compare(a[0], b[0]));


        // Sort by shortest processingTime and then index 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int c = Integer.compare(a[1], b[1]);
            if (c == 0) {
                return Integer.compare(a[2], a[2]);
            }

            return c;
        });

        int[] ans = new int[n];
        long time = 0;
        int i = 0, ind = 0;

        while (ind < n) {
            // Add all tasks that <= currentTime 
            while (i < n && t[i][0] <= time) {
                pq.offer(t[i++]);
            }
            if (pq.isEmpty()) {
                time = t[i][0];   // CPU idle, jump forward
                continue;
            }
            int[] curr = pq.poll();
            time += curr[1];
            ans[ind] = curr[2];
            ind++;
        }

        return ans;
    }
}