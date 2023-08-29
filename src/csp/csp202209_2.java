package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月29日 18:34
 * Description: 递归求数组中和大于x的最小集合
 */
public class csp202209_2 {

    public static void main(String[] args) {
        //动态规划 原题可转换为求得在n本书中删除书的总金额在(书的总价-包邮满减值 = x)中最大的
        //也即删除那几本书使得删除的价格在x内最大 背包问题
        Scanner in = new Scanner(System.in);
        int sum = 0;
        int n = in.nextInt();
        int x = in.nextInt();
        int[]cost = new int[n+1];
        for (int i=1;i<=n;i++) {
            cost[i] = in.nextInt();sum+=cost[i];
        }
        int sub = sum - x;//计算最大差价
        int[][]dp = new int[n+1][sub+1];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=sub;j++){
                if (cost[i] > j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-cost[i]]+cost[i]);
                }
            }
        }
        System.out.println(sum - dp[n][sub]);
    }
    //解法1==============================
    // static int answer = Integer.MAX_VALUE;
    // public static void main(String[] args) {
    //     System.out.println(answer);
    //     Scanner in = new Scanner(System.in);
    //     int n = in.nextInt();
    //     int x = in.nextInt();
    //     int[]cost = new int[n];
    //     for (int i=0;i<n;i++) cost[i] = in.nextInt();
    //     for (int i=0;i<n;i++)
    //         rev(cost,i,x,cost[i]);
    //     System.out.println(answer);
    // }
    //
    // private static  void rev(int[] cost, int i, int x, int cur){
    //     if (cur >= x) {
    //         answer = Math.min(answer,cur);
    //         return;
    //     }
    //     for (int j=i+1;j<cost.length;j++){
    //         rev(cost,j,x,cur+cost[j]);
    //     }
    // }
}
