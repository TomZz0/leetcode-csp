package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月28日 17:01
 * Description:
 */
public class csp202112_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int res = 0;
        int[]arr = new int[n+1];
        arr[0] = 0;
        for (int i=1;i<=n;i++) arr[i] = in.nextInt();
        for (m-=1;m>=0;m--){
            //计算fm
            int fm = 0;
            int i = n;
            while (arr[i] >m) i--;
            res += i;
        }
        System.out.println(res);
    }
}
