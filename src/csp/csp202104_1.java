package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月28日 18:17
 * Description:
 */
public class csp202104_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int l = in.nextInt();
        int[]arr = new int[l];
        for (int i=0;i<n*m;i++) arr[in.nextInt()]++;
        for (int j : arr) System.out.print(j+" ");
    }
}
