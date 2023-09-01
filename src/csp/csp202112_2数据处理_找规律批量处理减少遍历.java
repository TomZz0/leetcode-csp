package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月31日 12:52
 * Description:
 */
public class csp202112_2数据处理_找规律批量处理减少遍历 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long res = 0;
        int g1 = m / (n + 1);
        int len;
        int a = 0, b;
        for (int i = 0; i < n; i++) {
            b = a;
            a = in.nextInt();
            res = getRes(i, a, res, g1, b);
        }
        res = getRes(n, m, res, g1, a);
        System.out.println(res);
    }

    private static long getRes(int n, int m, long res, int g1, int a) {
        int len;
        for (int i = a; i < m; i+=len) {
            len = g1 - (i % g1);
            if (i + len > m) {
                len = m - i;
            }
            res += (long) len * Math.abs(i / g1 - n);
        }
        return res;
    }
}
