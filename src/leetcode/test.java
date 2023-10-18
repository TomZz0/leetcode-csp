package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * @author wzh
 * @date 2023年09月24日 18:31
 * Description:
 */
public class test {
    boolean flag;
    static int res;
    static int k;

    static  int[][] cal(int n){
        int[][]dp = new int[n+1][n+1];
        for (int i=1;i<=n;i++){
            dp[i][0]=1;
            dp[i][1] = i;
            dp[i][i] = 1;
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<i;j++){
                dp[i][j] = dp[i-1][j] * i / (i-j);
            }
        }
        return dp;
    }
    public static void main(String[] args) {
        int[]arr = {5,-9,-8,-7,-4,6,8,6,9};
        int[][]dp = new int[arr.length][2];
        int max = Integer.MIN_VALUE;int maxInd = 0;
        for (int i=1;i<arr.length;i++){
            dp[i][0] = 1;
            for (int j=0;j<i;j++){
                if (arr[j] >= arr[i]) continue;
                if (dp[j][0] + 1 > dp[i][0]){
                    dp[i][0] = dp[j][0]+1;
                    dp[i][1] = j;
                }
            }
            if (dp[i][0]>max){
                max = dp[i][0];
                maxInd = i;
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (max>0){
            list.addFirst(arr[maxInd]);
            maxInd = dp[maxInd][1];
            max--;
        }
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer+" ");
            }
        });

        // String s = "[123,[456,[789]]]";
        //
        // String[] split = s.split("$[|[,|]#");
        // System.out.println(split[0]);
        // System.out.println(s.substring(1));
        // TreeNode treeNode1 = new TreeNode(1);
        // TreeNode treeNode2 = new TreeNode(2);
        // TreeNode treeNode3 = new TreeNode(3);
        // TreeNode treeNode4 = new TreeNode(4);
        // treeNode3.left = treeNode1;
        // treeNode1.right = treeNode2;
        // treeNode3.right=treeNode4;
        // k=1;
        // new test().dfs(treeNode3);
        // System.out.println(res);
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (--k == 0 && !flag) {
            res = root.val;
            flag = true;
            return;
        } else if (flag) return;
        dfs(root.right);
    }

}
