class Solution {
    public void solve(char[][] board) {
        /* 
        Run BFS from all the border cells = O, since they can "escape" and should not be converted, 
            any 'O' cells that can be reached by border 'O' cells can therefore escape as well and 
            should not flip!
        Any remaining O that was not visited is definitely surrounded! -> Flip those to X
        
        Time complexity: O(R * C), one multi-source BFS seeded from border O’s, each cell 
            is enqueued at most once, followed by a R * C scan to check which cell == 'O' 
            is not visited yet
        Space complexity: O(R * C), visited 2D matrix takes up R * C space, queue can grow to 
            O(R * C) size as well
        */
        int rows = board.length, cols = board[0].length;
        boolean visited[][] = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>(); // For BFS

        // Scan left and right border
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                q.offer(new int[]{r,0});
                visited[r][0] = true;
            }

            if (board[r][cols - 1] == 'O') {
                q.offer(new int[]{r, cols - 1});
                visited[r][cols - 1] = true;
            }
        }

        // Scan top and bottom border
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                q.offer(new int[]{0,c});
                visited[0][c] = true;
            }

            if (board[rows - 1][c] == 'O') {
                q.offer(new int[]{rows - 1, c});
                visited[rows - 1][c] = true;
            }
        }

        // Movement matrix
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        // Perform BFS
        while (!q.isEmpty()) {
            int[] currCoor = q.poll();
            int currR = currCoor[0], currC = currCoor[1];
            // Check top,down,left and right neighbours
            for (int i = 0; i < 4; i++) {
                int newR = currR + dr[i], newC = currC + dc[i];
                // Check if neighbour cell is within grid
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols) {
                    if (board[newR][newC] == 'O' && !visited[newR][newC]) {
                        visited[newR][newC] = true;
                        q.offer(new int[]{newR, newC});
                    }
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O' && !visited[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }
}
