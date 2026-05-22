// Time Complexity: O(n^2), traverse through each cell on grid
// Space Complexity: O(n^2), creating 3n number of Hashsets, each Hashset can contain up to 9 elements, hence O(3n^2) = O(n^2)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Keep a HashSet for O(1) for each box, row and column
        // Index of each square by the equation (row / 3) * 3 + (col / 3)
        ArrayList<HashSet<Integer>> cols = new ArrayList<>();
        ArrayList<HashSet<Integer>> rows = new ArrayList<>();
        ArrayList<HashSet<Integer>> boxes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            cols.add(new HashSet<>());
            rows.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue; // Skip unfilled cells

                int currVal = Character.getNumericValue(board[r][c]);
                int boxIndex = (r / 3) * 3 + (c / 3);
                // Check if current cell's row, column and box Hashset already contains the currVal
                if (!rows.get(r).contains(currVal) 
                    && !cols.get(c).contains(currVal)
                    && !boxes.get(boxIndex).contains(currVal)) {
                        rows.get(r).add(currVal);
                        cols.get(c).add(currVal);
                        boxes.get(boxIndex).add(currVal);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
