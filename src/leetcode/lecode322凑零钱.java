package leetcode;

import java.util.Arrays;

/**
 * @author wzh
 * @date 2023年09月01日 15:29
 * Description:
 */
public class lecode322凑零钱 {
    int[] mem;

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(mem, Integer.MAX_VALUE);
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i < coin) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
    // public int coinChange(int[] coins, int amount) {
    //     mem = new int[amount];
    //     Arrays.fill(mem, -2);
    //     return dp(coins, amount);
    // }
    //
    // private int dp(int[] coins, int amount) {
    //     if (amount == 0) return 0;
    //     if (amount < 0) return -1;
    //     if (mem[amount] != -2) return mem[amount];
    //     int res = Integer.MAX_VALUE;
    //     for (Integer coin : coins) {
    //         //如果金额为(amount - 当前硬币)的总额存在硬币组合，则金额为amount的组合只需在前者基础上加一
    //         int subVal = dp(coins, amount - coin);
    //         if (subVal == -1) continue;
    //         res = Math.min(res, subVal + 1);
    //     }
    //     mem[amount] = res == Integer.MAX_VALUE ? -1 : res;
    //     return mem[amount];
    // }
}
