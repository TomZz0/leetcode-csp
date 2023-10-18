package leetcode;

/**
 * @author wzh
 * @date 2023年09月09日 14:54
 * Description:
 */
public class leetcode673 {
    public static void main(String[] args) {
        int numberOfLIS = findNumberOfLIS(new int[]{2,1});
        System.out.println(numberOfLIS);
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];

        int max = 0,num=0;
        for (int i = 0; i < n; i++) {

            dp[i] = 1;
            cnt[i]=1;
            for (int j = 0; j < i; j++) {
                //当nums[i] > nums[j] 可以增加递增序列
                if (nums[j] >= nums[i]) continue;
                //如果当前dp[j]+1 比dp[i] 也就是dp[j-1]+1 大 说明找到了更长的以nums[i]结尾的递增序列
                //更新dp 将序列个数设置为cnt[j]
                if (dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                }else if (dp[j] + 1 == dp[i]){
                    //这时说明发现一支和dp[i]一样长的序列 cnt+=cnt[j]
                    cnt[i] += cnt[j];
                }
            }
            if (dp[i]==max){
                num+=cnt[i];
            }else {
                num = cnt[i];
                max = dp[i];
            }

        }
        return num;
    }
}
