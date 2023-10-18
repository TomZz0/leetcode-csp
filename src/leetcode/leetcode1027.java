package leetcode;

/**
 * @author wzh
 * @date 2023年09月10日 11:48
 * Description:
 */
public class leetcode1027 {
    public static void main(String[] args) {

    }
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int res = 1;
        int[][] dp = new int[n][1001];
        for(int i=-500;i<=500;i++)dp[0][i+500]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                //如果dp[j]这一行不全为0 说明nums[j]是某些等差数列的最后一项
                int d = nums[i] - nums[j];
                if(dp[j][d+500]!=0) dp[i][d+500] = dp[j][d+500] + 1;
                else dp[i][d+500] = 2;
                res = Math.max(res,dp[i][d+500]);
            }
        }
        return res;
    }
}
