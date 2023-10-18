package leetcode;

/**
 * @author wzh
 * @date 2023年09月14日 15:24
 * Description:
 */
public class leetcode279 {
    public static void main(String[] args) {

    }

    // public int numSquares(int n) {
    //     int[] dp = new int[n + 1];
    //     for (int i = 1; i <= n; i++) {
    //         int min = Integer.MAX_VALUE;
    //         for (int j=1;j*j<=i;j++){
    //             min = Math.min(min,dp[i-j*j]);
    //         }
    //         dp[i] = min+1;
    //     }
    //     return dp[n];
    // }
    public int numSquares(int n) {
        if (isPerfectN(n)) return 1;
        if (is4(n)) return 4;
        for (int i=1;i*i<=n;i++){
            int j = n - i * i;
            if (isPerfectN(j)) return 2;
        }
        return 3;
    }

    public boolean isPerfectN(int n) {
        int y = (int) Math.pow(n, 0.5);
        return y * y == n;
    }

    public boolean is4(int n) {
        while (n % 4 == 0) n /= 4;
        return n % 8 == 7;
    }
}
