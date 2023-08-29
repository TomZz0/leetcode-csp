package csp;

import java.util.Scanner;


/**
 * @author wzh
 * @date 2023年08月28日 18:30
 * Description:
 */
public class csp202305_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[][] q = new int[n][d];
        int[][] k = new int[n][d];
        long[][] v = new long[n][d];
        int[][] t = new int[d][d];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                q[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                k[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                v[i][j] = in.nextInt();
            }
        }
        for (int i=0;i<d;i++){
            for (int j=0;j<d;j++){
                t[i][j] = mul(k,i,v,j,n);
            }
        }

        for (int i=0;i<n;i++){
            int m = in.nextInt();
            for (int j=0;j<d;j++){
                v[i][j] = m * mulp(q,i,t,j,d);
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int mul(int[][] q, int i, long[][] k, int j, int n) {
        int res = 0;
        for (int m = 0; m < n; m++) {
            res += (long)q[m][i] * k[m][j];
        }
        return res;
    }
    private static long mulp(int[][] q, int i, int[][] k, int j,int n) {
        //  N d * d d
        long res = 0;
        for (int m = 0; m < n; m++) {
            //mul函数返回qk的第i行的第m个数
            res += (long)q[i][m] * k[m][j];
        }
        return res;
    }
}
