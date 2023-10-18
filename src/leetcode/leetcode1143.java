package leetcode;

/**
 * @author wzh
 * @date 2023年09月11日 18:26
 * Description:
 */
public class leetcode1143 {
    public static void main(String[] args) {

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 =  text1.length();
        int len2 = text2.length();
        int[][]dp = new int[len1+1][len2+1];

        for (int i=1;i<=len1;i++){
            char ch1 = text1.charAt(i-1);
            for (int j=1;j<=len2;j++){
                char ch2 = text2.charAt(j-1);
                if (ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
