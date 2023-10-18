package leetcode;

import java.time.LocalDateTime;

/**
 * @author wzh
 * @date 2023年09月01日 15:12
 * Description:
 */
public class 斐波那契数列优化 {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        int x = so1(50);
        LocalDateTime end = LocalDateTime.now();
        System.out.println(start+"  "+end);
        int[] arr = new int[51];
        LocalDateTime start1 = LocalDateTime.now();
        int y = so2(arr, 50);
        LocalDateTime end1 = LocalDateTime.now();
        System.out.println(start1+"  "+end1);
    }

    private static int so1(int n) {
        if (n == 0 || n == 1) return n;
        return so1(n - 1) + so1(n - 2);
    }

    private static int so2(int[] mem, int n) {
        if (n == 0 || n == 1) return n;
        if (mem[n] != 0) return mem[n];
        mem[n] = so2(mem, n - 1) + so2(mem, n - 2);
        return mem[n];
    }
}
