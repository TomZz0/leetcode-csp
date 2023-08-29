package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月28日 20:42
 * Description:
 */
public class csp202212_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] dep = new int[m+1];
        int[] cost = new int[m+1];
        int[] early = new int[m+1];
        int[] late = new int[m+1];
        for (int i = 1; i <= m; i++) dep[i] = in.nextInt();
        for (int i = 1; i <= m; i++) cost[i] = in.nextInt();
        for (int i = 1; i <= m; i++)
            if (dep[i] == 0) {
                early[i] = 1;
            }
        while (!finish(early)) {
            for (int i = 1; i <= m; i++) {
                if (dep[i] == 0) continue;
                if (early[i] == 0 && early[dep[i]] != 0) early[i] = early[dep[i]]+cost[dep[i]];
            }
        }
        for (int i = 1; i <= m; i++) System.out.print(early[i] + " ");
        for (int i=1;i<=m;i++) if (early[i] + cost[i]-1 > n) System.exit(0);
        System.out.println();
        int index;
        boolean[] ifHandle = new boolean[m+1];
        for (int i=1;i<=m;i++) ifHandle[i] = false;
        while (!finishP(ifHandle)){
            //寻找依赖关系的最底部 倒退被依赖课程的最晚开始时间
            index = find(early,ifHandle);
            if (index < 0) continue;
            late[index] = n - cost[index] + 1;
            ifHandle[index] = true;
            while (dep[index] != 0){
                int i = late[index] - cost[dep[index]];
                if (ifHandle[dep[index]])
                late[dep[index]] = Math.min(late[dep[index]], i);
                else late[dep[index]] = i;
                index = dep[index];
                ifHandle[index] = true;
            }
        }
        for (int i=1;i<=m;i++) System.out.print(late[i] + " ");
    }

    private static boolean finishP(boolean[] ifHandle) {
        for (int i=1;i<ifHandle.length;i++) if (!ifHandle[i]) return false;
        return true;
    }

    private static int find(int[] early, boolean[] ifHandle) {
        int maxInd = -1; int max = 0;
        for (int i=1;i<early.length;i++){
            if (ifHandle[i]) continue;
            if ( early[i] > max) {
                maxInd = i;max = early[i];
            }
        }
        return maxInd;
    }

    private static boolean finish(int[] early) {
        boolean res = true;
        for (int i=1;i<early.length;i++)
            if (early[i] == 0) {
                res = false;
                break;
            }
        return res;
    }
}


