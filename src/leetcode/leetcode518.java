package leetcode;

import java.util.HashSet;

/**
 * @author wzh
 * @date 2023年09月14日 16:16
 * Description:
 */
public class leetcode518 {
    public static void main(String[] args) {
        int amount = 5;
        int[]arr = {1,2,5};
        int change = new leetcode518().change(amount, arr);
        System.out.println(change);
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        HashSet<Integer> integers = new HashSet<>();
        for (Integer integer : coins) {
            integers.add(integer);
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < i; j++) {
                if (integers.contains(i - j)&&dp[j]!=0) dp[i] += dp[j];
            }
        }
        return dp[amount];
    }
}
