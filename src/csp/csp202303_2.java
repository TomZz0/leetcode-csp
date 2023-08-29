package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月28日 19:58
 * Description: 用桶来解决问题 从用时最高的向前逐步处理
 */
public class csp202303_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        int k = in.nextInt();
        int max = 0;
        int[]arr = new int[100001];
        for (int i=0;i<n;i++) {
            int x = in.nextInt();int cos = in.nextInt();
            arr[x]+=cos;
            if (x > max) max = x;
        }
        while (max > k) {
            if (m >= arr[max]) {
                int cost = arr[max];
                m -= arr[max];
                arr[max] = 0;
                arr[max-1]+=cost;
                while (max>k&&arr[max] ==0) max--;
            }else break;
        }
        System.out.println(max);
    }
}
