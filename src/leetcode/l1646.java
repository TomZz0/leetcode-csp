package leetcode;

/**
 * @author wzh
 * @date 2023年09月05日 17:19
 * Description:
 */
public class l1646 {
    public static void main(String[] args) {
        int[]arr={1,15,7,9,2,5,10};int k = 3;
        maxSumAfterPartitioning(arr,k);
    }
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[]dp=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int max = 0;
            int cnt = 0;
            for(int j=i;j<arr.length;j++){
                if(arr[j] >max)max = arr[j];
                cnt++;
                if(cnt > k) break;
                if(j!=arr.length-1)    dp[i] = Math.max(dp[i],dp[j+1]+cnt*max);
                else dp[i] = Math.max(dp[i],cnt*max);
            }
        }
        return dp[0];
    }
}
