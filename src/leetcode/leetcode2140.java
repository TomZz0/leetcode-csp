package leetcode;

/**
 * @author wzh
 * @date 2023年09月16日 13:45
 * Description:
 */
public class leetcode2140 {
    public static void main(String[] args) {
        int[][] a = {
                {3, 2},
                {4, 3},
                {4, 4},
                {2, 5}};
        long l = new leetcode2140().mostPoints(a);
        System.out.println(l);
    }

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        int[][] dp = new int[n][2];
        dp[0][1] = questions[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            int max = questions[i][0];
            for (int j = 0; j < i; j++) {
                if (j + questions[j][1] >= i) max = Math.max(max,Math.max(questions[i][0],dp[j][0]));
                else max = Math.max(max, questions[i][0] + dp[j][1]);
            }
            dp[i][1] = max;
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
