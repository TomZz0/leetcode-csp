package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年08月28日 15:16
 * Description:
 */
public class csp202303_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int x = in.nextInt();int y = in.nextInt();
        int res = 0;
        for (int i=0;i<num;i++){
            int lx = in.nextInt();
            int ly = in.nextInt();
            int rx = in.nextInt();
            int ry = in.nextInt();
             if (ry<0||rx <0||lx>x||ly>y) continue;
            int high = Math.min(y,ry)-Math.max(0,ly);
            int width =  Math.min(x,rx) - Math.max(0,lx);
            res+=high * width;
        }
        System.out.println(res);
    }
}
