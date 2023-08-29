package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月28日 16:32
 * Description:
 */
public class csp202206_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a1 = new int[n];
        double[] a2 = new double[n];
        double sum = 0;
        for (int i=0;i<n;i++){
            a1[i] = in.nextInt();
            sum += a1[i];
        }
        double ave = sum / (n*1.0);
        double D = 0;
        for (int i=0;i<n;i++){
            D += Math.pow(a1[i]*1.0 - ave,2);
        }
        D /= (n*1.0);
        for (int i=0;i<a2.length;i++){
            a2[i] = (a1[i] - ave) / Math.pow(D,0.5);
            System.out.println(a2[i]);
        }
    }
}
