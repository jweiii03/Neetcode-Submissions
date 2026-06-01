// Time Complexity: O(log(m * n)) - Binary search halves the search space each iteration across all m*n elements.
// Space Complexity: O(1) - Only a few variables are used regardless of matrix size.


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix[0].length;

        // Treat the 2D matrix as a sorted 1D array:
        // [1,3,5]
        // [7,9,11]
        // becomes [1,3,5,7,9,11]
        int left = 0;
        int right = matrix.length * rowLen - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert the 1D index back into 2D coordinates
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
