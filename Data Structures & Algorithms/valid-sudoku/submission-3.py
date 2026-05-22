class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = []
        cols = []
        boxes = []

        for i in range(9):
            rows.append(set())
            cols.append(set())
            boxes.append(set())

        for r in range(9):
            for c in range(9):
                if board[r][c] == '.':
                    continue
                
                currVal = board[r][c]
                boxIndex = (r // 3) * 3 + (c // 3)
                if currVal not in rows[r] and currVal not in cols[c] and currVal not in boxes[boxIndex]:
                    rows[r].add(currVal)
                    cols[c].add(currVal)
                    boxes[boxIndex].add(currVal)
                else:
                    return False
        return True