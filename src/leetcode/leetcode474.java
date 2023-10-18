package leetcode;

/**
 * @author wzh
 * @date 2023年09月15日 16:18
 * Description:
 */
public class leetcode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][]dp = new int[l+1][m+1][n+1];
        for (int i=1;i<=l;i++){
            int[] numOf_1_0 = get(strs[i-1]);
            int num_0 = numOf_1_0[0];
            int num_1 = numOf_1_0[1];
            for (int j=1;j<=m;j++){
                for (int k=1;k<=n;k++){
                    dp[i][j][k] = dp[i-1][j][k];
                    if (j>=num_0 && k>=num_1){
                        dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j-num_0][k-num_1]+1);
                    }
                }
            }
        }
        return dp[l][m][n];
    }

    private int[] get(String str) {
        int x = 0,y=0;
        for (int i=0;i<str.length();i++)
            if (str.charAt(i) == '1') y++;
            else x++;
        return new int[]{x,y};
    }

}
