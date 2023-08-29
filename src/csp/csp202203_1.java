package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月28日 16:39
 * Description:
 */
public class csp202203_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int k = in.nextInt();
         int res = 0;
         int[] arr = new int[100001];
         arr[0] = 1;
         for (int i=0;i<k;i++){
             int l = in.nextInt();
             int r = in.nextInt();
             res += 1 - arr[r];
             arr[l] = 1;
         }
        System.out.println(res);
    }
}
