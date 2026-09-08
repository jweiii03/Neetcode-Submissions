class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>(); // int[] -> (r, c)
        int[][] distance = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If rotten fruit
                if (grid[r][c] == 2) {
                    distance[r][c] = 0;
                    q.offer(new int[]{r, c});
                    continue;
                } 

                distance[r][c] = -1;
            }
        }

        // Movement matrix
        int[] dr = new int[]{0,-1,0,1};
        int[] dc = new int[]{1,0,-1,0};

        // BFS
        while (!q.isEmpty()) {
            int[] currCoor = q.poll();
            int currR = currCoor[0], currC = currCoor[1];

            // Check neighbours
            for (int i = 0; i < 4; i++) {
                int newR = currR + dr[i], newC = currC + dc[i];
                // Check if out of bound
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols) {
                    // Check if visited already and if its a fresh fruit
                    if (grid[newR][newC] == 1 && distance[newR][newC] == -1) {
                        distance[newR][newC] = distance[currR][currC] + 1;
                        q.offer(new int[]{newR, newC});
                    }
                }
            }
        }

        int minMinutes = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.println(distance[r][c]);
                // If fresh fruit initially and not rotten, return -1
                if (grid[r][c] == 1 && distance[r][c] == -1) {
                    return -1;
                }
                
                if (grid[r][c] == 1) {
                    minMinutes = Math.max(minMinutes, distance[r][c]);
                }
            }
        }

        return minMinutes;
    }
}
