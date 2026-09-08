class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // For BFS
        Queue<int[]> q = new LinkedList<>();

        // Movement matrix
        int[] dr = new int[]{0,1,0,-1};
        int[] dc = new int[]{1,0,-1,0};

        int noOfIslands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                    noOfIslands++;
                }

                while (!q.isEmpty()) {
                    int[] currCoor = q.poll();
                    int currRow = currCoor[0], currCol = currCoor[1];

                    for (int i = 0; i < 4; i++) {
                        int newRow = currRow + dr[i];
                        int newCol = currCol + dc[i];

                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                            if (!visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                                q.offer(new int[]{newRow, newCol});
                                visited[newRow][newCol] = true;
                            }
                        }
                    }
                }
            }
        }

        return noOfIslands;
    }
}
