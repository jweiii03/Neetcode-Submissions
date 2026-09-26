class Solution {
    public int islandPerimeter(int[][] grid) {
        // We will use BFS here
        // To measure the perimeter, we can increment the perimeter variable by 1 when it 1) Goes out of bounds or 2) Finds a neighbour that is not land (== 0)
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int perimeter = 0;
        Queue<int[]> q = new LinkedList<>();

        int[] dr = new int[]{0,1,0,-1};
        int[] dc = new int[]{1,0,-1,0};

        // Loop through all grid to find that one exact island
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    q.offer(new int[]{r,c});
                    visited[r][c] = true;
                    // BFS
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int currR = curr[0], currC = curr[1];
                        for (int i = 0; i < 4; i++) {
                            int nRow = currR + dr[i], nCol = currC + dc[i];
                            // Check if out of bounds or neighbour is not land
                            if (nRow < 0 || nRow >= rows || nCol < 0 || nCol >= cols || grid[nRow][nCol] == 0) {
                                perimeter++;
                            } else if (grid[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                                visited[nRow][nCol] = true;
                                q.offer(new int[]{nRow, nCol});
                            }
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}