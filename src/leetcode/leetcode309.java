package leetcode;

/**
 * @author wzh
 * @date 2023年09月12日 19:13
 * Description:只可能计算每天结束后的状况 所以若今天卖出股票 今天结束后就是冷冻期 直到明天结束
 */
public class leetcode309 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //不持有股票不处于冷冻期 今天啥也没干
            dp[i][0] =  Math.max(dp[i-1][0],dp[i-1][2]);
            //持有股票 可能前一天持有今天未卖出 前一天未持有今天购入 这两种情况昨天结束不是冷冻期
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            //冷冻期 说明今天一定卖出股票
            dp[i][2] = dp[i-1][1]+prices[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][2]);
    }
}
