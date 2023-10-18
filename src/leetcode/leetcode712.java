package leetcode;

/**
 * @author wzh
 * @date 2023年09月08日 14:20
 * Description:
 */
public class leetcode712 {
    public static void main(String[] args) {

    }

    public int minimumDeleteSum(String s1, String s2) {
        //dp[i][j]代表 使s1前i个字符与s2前j个字符相同的最小删除和
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        //当j=0 要将i串全部删除 i等于0 同样
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + (int) s1.charAt(i);
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j-1] + (int) s2.charAt(j);
        }
        //其余情况
        for (int i=1;i<=len1;i++){
            int ascii1 = s1.codePointAt(i);
            for (int j=1;j<=len2;j++){
                int ascii2 = s2.codePointAt(j);
                if (ascii1 == ascii2){
                    dp[i][j] = dp[i-1][j-1];//不需要删除
                }else {
                    //删除两个字母中ascii更小的
                    dp[i][j] = Math.min(dp[i-1][j] + s1.codePointAt(i),dp[i][j-1]+s2.codePointAt(j));
                }
            }
        }
        return dp[len1][len2];
    }
}
