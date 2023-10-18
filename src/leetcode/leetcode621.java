package leetcode;


import java.util.Arrays;

/**
 * @author wzh
 * @date 2023年10月06日 14:05
 * Description:
 */
public class leetcode621 {

    public static void main(String[] args) {
        // char[] ch = {'B', 'B', 'B', 'B', 'B', 'B', 'A', 'C', 'D', 'E', 'F', 'G'};
        char[] ch = {'B', 'B', 'B', 'A', 'A', 'A', 'A'};
        int n = 2;
        int i = new leetcode621().leastInterval(ch, n);
        System.out.println(i);
    }

    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (n == 0) return len;
        int[][] left = new int[26][2];
        for (char task : tasks) {
            left[task - 'A'][0]++;
            left[task - 'A'][1] = Integer.MIN_VALUE;
        }
        int time = 0;
        int num = 0;
        while (num < len) {
            int index = 0;
            Arrays.sort(left, (x, y) -> y[0] - x[0]);
            if (judge(left, time, n)) {
                time++;
                continue;
            } else while (left[index][0] == 0 || left[index][1] + n > time) index = (index + 1) % 26;
            time++;
            left[index][0]--;
            num++;
            left[index][1] = time;
        }
        return time;
    }

    private boolean judge(int[][] left, int time, int n) {
        for (int i = 0; i < 26; i++) {
            if (left[i][0] > 0 && left[i][1] + n <= time) return false;
        }
        return true;
    }
}
