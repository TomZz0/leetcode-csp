package csp;


import java.util.*;


/**
 * @author wzh
 * @date 2023年08月31日 15:19
 * Description: 从最小的开始削减 这样所有可能的非零段数一定都会得到
 * 在置0时即可进行处理 若两边都为0 置0后非零段-1 若都不为零 则+1
 * 为了防止进行有关处理时数组下标越界可以左右均多开一个空间并置0 这样判断开头时 左边为零，结尾时右边为零可以一并判断。
 */
public class csp202109_2海岛问题露出水面最多 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n + 2];
        ArrayList<Integer>[] lists = new ArrayList[10001];
        //读取输入 存数
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
            if (lists[arr[i]] == null) lists[arr[i]] = new ArrayList<>();
            lists[arr[i]].add(i);
        }
        //求初始非零段
        int max = count(arr);
        int temp = max;
        //从小到大尝试置零求非零段数
        for (int i = 1; i < 10001; i++) {
            if (lists[i] == null) continue;
            for (Integer j : lists[i]) {
                arr[j] = 0;
                if (arr[j - 1] == 0 && arr[j + 1] == 0) temp--;
                if (arr[j - 1] != 0 && arr[j + 1] != 0) temp++;
            }
            if (temp > max) max = temp;
            if (max == (n%2==0?n:n+1)/2) break;
        }
        System.out.println(max);
    }

    private static int count(int[] arr) {
        int res = 0;
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i - 1] == 0 && arr[i] > 0) res++;
        }
        return res;
    }
}
