package leetcode;

/**
 * @author wzh
 * @date 2023年09月03日 11:25
 * Description:
 */
public class 最长回文子序列 {
    public static void main(String[] args) {
        longestPalindromeSubseq("bbbab");
    }
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][]dp = new int[n][n];
        for(int i=0;i<n;i++)dp[i][i] = 1;
        for(int i=0;i<n;i++){
            char ch1 = s.charAt(i);
            for(int j=i-1;j>=0;j--){
                if(ch1 == s.charAt(j)){
                    dp[j][i]=dp[j+1][i-1] + 2;
                }else{
                    dp[j][i]=Math.max(dp[j+1][i],dp[j][i-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
