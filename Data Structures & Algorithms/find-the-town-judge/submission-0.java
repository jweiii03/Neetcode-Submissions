class Solution {
    public int findJudge(int n, int[][] trust) {
        // Town judge will have n - 1 indegree edges and 0 outdegree edge
        int[][] degrees = new int[n][2]; // int[] -> [indegree, outdegree]

        for (int[] edge : trust) {
            // 1 indexed
            int from = edge[0] - 1, to = edge[1] - 1;
            degrees[from][1]++;
            degrees[to][0]++;
        }

        int judge = -1;
        for (int i = 0; i < n; i++) {
            int[] curr = degrees[i];
            
            // Another judge found
            if (judge != -1 && curr[0] == n - 1 && curr[1] == 0) {
                return -1;
            }

            if (judge == -1 && curr[0] == n - 1 && curr[1] == 0) {
                judge = i + 1;
            }
        }

        return judge;
    }
}