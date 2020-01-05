public class LeetCode300_LongestIncreaingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length+1][length+1];
        for(int i = 0; i <= length; i++) {
            dp[0][i] = dp[i][0] = 1;
        }
        int result = length == 0 ? 0 : 1;
        for(int i = 1; i <= length; i++) {
            dp[i][i] = 1;
            for(int j = i+1; j <= length; j++) {
                if(nums[j-1] > nums[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][i] + 1);
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
                result = Math.max(dp[i][j], result);
                System.out.printf(dp[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }
    public static void main(String[] args) {
        LeetCode300_LongestIncreaingSubsequence solution = new LeetCode300_LongestIncreaingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        solution.lengthOfLIS(nums);
    }
}
