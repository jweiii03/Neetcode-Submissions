class Solution {
    // Movement matrix
    int[] dr = new int[]{0, 1, 0, -1};
    int[] dc = new int[]{1, 0, -1, 0};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Reverse the thinking: BFS from each ocean border cell (Both atlantic and pacific)
        // When traversing, move uphill/flat (Downhill means that cell cannot traverse to that grid cell, since water cant flow uphill)
        // Data structures to use: Queue for BFS, Two boolean visited grids -> One for atlantic, one for pacific

        int rows = heights.length, cols = heights[0].length;

        boolean[][] visitedPacific = new boolean[rows][cols];
        boolean[][] visitedAtlantic = new boolean[rows][cols];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        // Append border cells
        for (int c = 0; c < cols; c++) {
            pacQueue.offer(new int[]{0, c});
            atlQueue.offer(new int[]{rows - 1, c});
        }

        for (int r = 0; r < rows; r++) {
            pacQueue.offer(new int[]{r, 0});
            atlQueue.offer(new int[]{r, cols - 1});
        }

        bfs(pacQueue, visitedPacific, heights);
        bfs(atlQueue, visitedAtlantic, heights);

        List<List<Integer>> ans = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (visitedPacific[r][c] && visitedAtlantic[r][c]) {
                    ans.add(new ArrayList<>(Arrays.asList(r, c)));
                }
            }
        }

        return ans;
    }

    public void bfs(Queue<int[]> q, boolean[][] visited, int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        while (!q.isEmpty()) {
            int[] currCoor = q.poll();
            int currR = currCoor[0], currC = currCoor[1];
            visited[currR][currC] = true;
            // Traverse neighbours
            for (int i = 0; i < 4; i++) {
                int nRow = currR + dr[i];
                int nCol = currC + dc[i];
                // Check if within the grid
                if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols) {
                    if (heights[nRow][nCol] >= heights[currR][currC] && !visited[nRow][nCol]) {
                        q.offer(new int[]{nRow, nCol});
                    }
                }
            }
        }
    }
}
