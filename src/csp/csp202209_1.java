package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月28日 16:05
 * Description:
 */
public class csp202209_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int m = in.nextInt();
         int[] a = new int[n];
         int[] b = new int[n];
         int[] c = new int[n];
         for (int i=0;i<n;i++) a[i] = in.nextInt();
         c[0] =1;
         for (int i=1;i<n;i++) c[i] = c[i-1] * a[i-1];
         for (n-=1;n>=0;n--){
             for (int i=a[n]-1;i>0;i--){
                 if (m >= i*c[n]){
                     m -= i*c[n];
                     b[n] = i;
                 }
             }
         }
        for (int i :b) {
            System.out.print(i+" ");
        }

    }
}
