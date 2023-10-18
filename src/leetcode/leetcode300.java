package leetcode;

/**
 * @author wzh
 * @date 2023年09月08日 15:53
 * Description:dp[i]表示以第i个字母结尾的最大子序列的长度
 */
public class leetcode300 {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n];
        dp[0]=1;int res = 1;
        for(int i=1;i<n;i++){
            int max = 1;

            for (int j=0;j<i;j++){
                if (nums[j] >= nums[i]) continue;
                int cur = dp[j]+1;
                if (cur > max) max = cur;
            }
            dp[i] = max;
            if(max > res) res = max;
        }
        return res;
    }
}
