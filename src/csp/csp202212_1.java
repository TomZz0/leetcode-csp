package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月28日 15:53
 * Description:
 */
public class csp202212_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        double rate = in.nextDouble();
        double res = in.nextDouble();
        double[] m = new double[y+1];

        for (int i=1;i<m.length;i++){
            m[i] = in.nextDouble();
            res += m[i] * Math.pow(1+rate,-1 * i);
        }
        System.out.println(res);
    }
}
