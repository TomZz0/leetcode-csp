package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月28日 18:07
 * Description:
 */
public class csp202109_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 0, min = 0;
        int cmax = -1;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            max += x;
            if (x > cmax){
                min += x;
                cmax = x;
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
