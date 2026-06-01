class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix[0].length;
        int right = matrix.length * rowLen - 1;

        int left = 0;

        while (right >= left) {
            int mid = (right + left) / 2;

            int rowInd = mid / rowLen;
            int colInd = mid % rowLen;
            int currNum = matrix[rowInd][colInd];

            if (currNum > target) {
                right = mid - 1;
            } else if (currNum < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
