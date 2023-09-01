package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月30日 18:40
 * Description: 差分数组
 */
public class csp202203_2差分数组 {
    static int N = 400000+10;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (x <= k)continue;
            int l = x -k - y + 1 >0?x-k-y+1:1;
            int r = x-k;
            arr[l] +=1;
            arr[r+1] -=1;
        }
        for (int i=1;i<N;i++)arr[i]+=arr[i-1];
        for (int i=0;i<m;i++) System.out.println(arr[in.nextInt()]);
    }
}

