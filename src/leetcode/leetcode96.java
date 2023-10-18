package leetcode;

/**
 * @author wzh
 * @date 2023年09月13日 17:59
 * Description:
 */
public class leetcode96 {
    public static void main(String[] args) {
        int i = new leetcode96().numTrees(2);
        System.out.println(i);
    }

    /**
     * dp[i]表示i个节点互不相同共有多少个二叉搜索树
     */
    public int numTrees(int n) {
        int[]dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2;i<=    n;i++){
            int cur = 0;
            for (int j=1;j<=i;j++){
                int left = j-1;
                int right = i-j;
                cur += dp[left] * dp[right];
            }
            dp[i] = cur;
        }
        return dp[n];
    }
}
