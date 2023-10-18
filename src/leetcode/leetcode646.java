package leetcode;

import java.util.Arrays;

/**
 * @author wzh
 * @date 2023年09月09日 18:39
 * Description:
 */
public class leetcode646 {
    public static void main(String[] args) {
        int[][] arr = {{5,9},{-1,8},{-6,-2},{8,9},{4,8},{3,6},{2,6},{5,9},{-1,6},{-8,-7}};
        int longestChain = findLongestChain(arr);
        System.out.println(longestChain);
    }

    public static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[n-1];
    }
}
