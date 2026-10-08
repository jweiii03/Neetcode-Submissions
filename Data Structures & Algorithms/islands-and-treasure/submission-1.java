/*
Time complexity: During BFS, each cell is enqueued at most once and checks four neighbours, so total work is O(4 x R × C) = O(R x C)
Space: The queue can hold O(R × C) cells in the worst case. Reusing grid avoids a separate distance array.
*/

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // Source nodes here = treasure chest
        // We can reuse grid as a distance[][] array
        // BFS from each treasure chest since distance is equal btwn any 2 grid cells
        int rows = grid.length, cols = grid[0].length;

        // Queue for BFS
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        // Movement matrix
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        while (!q.isEmpty()) {
            int[] currCoor = q.poll();
            int currR = currCoor[0], currC = currCoor[1];
            // Traverse neighbours
            for (int i = 0; i < 4; i++) {
                int nRow = currR + dr[i], nCol = currC + dc[i];
                // Check within grid
                if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols) {
                    // Check if visited
                    if (grid[nRow][nCol] == Integer.MAX_VALUE) {
                        grid[nRow][nCol] = grid[currR][currC] + 1;
                        q.offer(new int[]{nRow, nCol});
                    }
                }
            }
        }
    }
}
