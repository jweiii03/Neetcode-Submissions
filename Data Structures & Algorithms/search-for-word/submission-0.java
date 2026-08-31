/*
 * Time complexity: O(R * C * 3^L)
 *
 * R * C:
 * We may start DFS from every cell in the board.
 *
 * 3^L:
 * L is the length of the word.
 *
 * From the starting cell, DFS can initially search in 4 directions.
 * After that, each cell has at most 3 usable directions because DFS
 * cannot return to the cell it just visited.
 *
 * This gives approximately:
 *
 *     R * C * 4 * 3^(L - 1)
 *
 * After removing the constant factor 4:
 *
 *     O(R * C * 3^L)
 *
 * This is a worst-case bound. In practice, many paths terminate early
 * when the board's character does not match the next word character.
 *
 * Space complexity: O(L)
 *
 * The recursion stack and visited set contain at most L cells,
 * corresponding to the current candidate path.
 */

class Solution {
    private HashSet<List<Integer>> visited;
    private String word;
    private int rows;
    private int cols;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.word = word;
        this.visited = new HashSet<>();
        this.board = board;

        // Brute force and run dfs on each coordinate on board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(r, c, 0))   return true;
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, int currInd) {
        if (currInd == word.length())   return true; 
        List<Integer> currCoordinate = new ArrayList<>(List.of(r, c));

        if (r < 0 || r >= rows || c < 0 || c >= cols
            || visited.contains(currCoordinate)
            || word.charAt(currInd) != board[r][c]) {    
                return false;
        }

        // Means we found correct letter, search neighbours for next 
        visited.add(new ArrayList<>(List.of(r, c)));
        boolean res =  dfs(r + 1, c, currInd + 1) ||
                        dfs(r - 1, c, currInd + 1) ||
                        dfs(r, c + 1, currInd + 1) ||
                        dfs(r, c - 1, currInd + 1);
        visited.remove(currCoordinate);
        return res;
    }
}