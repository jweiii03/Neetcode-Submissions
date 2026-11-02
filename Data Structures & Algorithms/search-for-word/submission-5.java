// Time complexity: O(R · C · 4 · 3^(L-1)) = O(R * C * 3^(L)) (3^L as each step checks 3 posisble neighbours excluding the cell dfs visited b4)
// Space complexity: Recursion stack grows up to O(L) and also visited hashset can grow up to O(L)
class Solution {
    char[][] grid;
    int rows;
    int cols;
    HashSet<String> visited;
    String w;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        grid = board;
        visited = new HashSet<>();
        w = word;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(r, c, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, int currLen, String word) {
        // Check if found word
        if (currLen >= word.length()) {
            return true;
        }

        String coordinates = r + "," + c;

        // Check if within grid or if curr letter is correct or if visiting a prev cell
        if (r < 0 || r >= rows || c < 0 || c >= cols || word.charAt(currLen) != grid[r][c]
            || visited.contains(coordinates)) {
                return false;
            } 

        visited.add(coordinates);
        boolean containWord = dfs(r + 1, c, currLen + 1, word) 
                              || dfs(r - 1, c, currLen + 1, word) 
                              || dfs(r, c + 1, currLen + 1, word) 
                              || dfs(r, c - 1, currLen + 1, word);
        visited.remove(coordinates);
        return containWord; 
    }
}
