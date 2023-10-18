package leetcode;

/**
 * @author wzh
 * @date 2023年09月12日 18:58
 * Description:
 */
public class leetcode122 {
    /**
     * 可以多次购买和出售
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        /**
         * 使用dp[i][0]表示第i天结束不持有股票状态下的最大利润 dp[i][1]表示持有
         */
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //不持有股票 可能前一天持有今天卖出 可能是前一天不持有且今天未买
            dp[i][0] =  Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //持有股票 可能前一天持有今天未卖出 前一天未持有今天购入
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}
