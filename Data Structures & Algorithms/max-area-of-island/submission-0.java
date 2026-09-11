class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int maxArea = 0;
        // Queue for BFS
        Queue<int[]> q = new LinkedList<>();

        // Movement matrix
        int[] dr = new int[]{0,1,0,-1};
        int[] dc = new int[]{1,0,-1,0};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If find unvisited land
                if (!visited[r][c] && grid[r][c] == 1) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                } 

                int currCount = 0;
                while (!q.isEmpty()) {
                    currCount++;
                    int[] currCoor = q.poll();
                    int currR = currCoor[0], currC = currCoor[1];

                    // Check neighbours
                    for (int i = 0; i < 4; i++) {
                        int newR = currR + dr[i], newC = currC + dc[i];
                        // Check if neighbour within grid
                        if (newR >= 0 && newR < rows && newC >= 0 && newC < cols) {
                            // Check if its an unvisited land
                            if (grid[newR][newC] == 1 && !visited[newR][newC]) {
                                q.offer(new int[]{newR, newC});
                                visited[newR][newC] = true;
                            }
                        }
                    }
                }

                maxArea = Math.max(maxArea, currCount);
            }
        }

        return maxArea;
    }
}
