package leetcode;

/**
 * @author wzh
 * @date 2023年09月03日 10:14
 * Description:
 */
public class 最长回文字串 {
    public String longestPalindrome(String s) {
        int maxL = 0,maxR = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int r=1;r<len;r++){
            for (int l=0;l<r;l++){
                if (s.charAt(r) == s.charAt(l) && (r-l<=2||dp[r-1][l+1])){
                    dp[r][l] = true;
                    if (r-l+1 > maxR-maxL+1){
                        maxL = l;maxR = r;
                    }
                }
            }
        }

        return s.substring(maxL,maxR+1);
    }
}
