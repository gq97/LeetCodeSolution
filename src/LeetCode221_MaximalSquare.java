public class LeetCode221_MaximalSquare {
    public boolean isSquare(char[][] matrix, int row, int col, int rows, int cols, int k) {
        while(col < cols) {
            if(matrix[row][col++] == '0') return false;
        }
        col--;
        while(row < rows) {
            if(matrix[row++][col] == '0') return false;
        }
        row--;
        while(col >= cols-k) {
            if(matrix[row][col--] == '0') return false;
        }
        col++;
        while(row >= rows-k) {
            if(matrix[row--][col] == '0') return false;
        }
        return true;
    }
    // Brute Force O((mn)^2) O(1)
    public int maximalSquare2(char[][] matrix) {
        int result = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '1') {
                    int k = 1;
                    for(; i+k <= matrix.length && j+k <= matrix[i].length; k++) {
                        if(!isSquare(matrix, i, j, i+k, j+k, k)) {
                            break;
                        }
                    }
                    k--;
                    result = Math.max(result, k*k);
                }
            }
        }
        return result;
    }

    // Dynamic Programming O(mn) O(n)
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols+1];
        int maxLen = 0, prev = 0;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j], dp[j-1]), prev) + 1;
                    maxLen = Math.max(maxLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxLen * maxLen;
    }
    // Dynamic Programming O(mn) O(mn)
    public int maximalSquare3(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}

