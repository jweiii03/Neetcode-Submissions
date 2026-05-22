class Solution {
    public boolean isValidSudoku(char[][] board) {
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
