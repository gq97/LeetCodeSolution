public class LeetCode188_BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int result = 0;
        int len = prices.length;
        if(len == 0 || k <= 0) return 0;
        if(k >= len/2) {
            for(int i = 1; i < len; i++) {
                if(prices[i] > prices[i-1]) {
                    result += prices[i] - prices[i-1];
                }
            }
            return result;
        }
        int[][][] dp = new int[len][k+1][2];
        for(int i = 1; i <= k; i++) {
            for(int j = 0; j < len; j++) {
                if(j == 0) {
                    dp[j][i][0] = 0;
                    dp[j][i][1] = -prices[j];
                    continue;
                }
                dp[j][i][0] = Math.max(dp[j-1][i][0], dp[j-1][i][1]+prices[j]);
                dp[j][i][1] = Math.max(dp[j-1][i][1], dp[j-1][i-1][0]-prices[j]);
            }
        }

        return dp[len-1][k][0];
    }

    public static void main(String[] args) {
        LeetCode188_BestTimetoBuyandSellStockIV solution = new LeetCode188_BestTimetoBuyandSellStockIV();
        int[] prices = {1,2,4,2,5,7,2,4,9,7};
        int k = 4;
        System.out.println(solution.maxProfit(k, prices));
    }
}
