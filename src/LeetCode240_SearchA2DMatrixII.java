public class LeetCode240_SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = m != 0 ? matrix[0].length : 0;
        if(m == 0 || n == 0) return false;
        int row = m-1, col = 0;
        while(row > -1 && col < n && matrix[row][col] != target) {
            if(target > matrix[row][col]) {
                col++;
            } else {
                row--;
            }
        }
        return row > -1 && col < n && matrix[row][col] == target;
    }
}
