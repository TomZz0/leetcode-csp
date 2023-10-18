package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wzh
 * @date 2023年10月09日 17:27
 * Description:
 */
public class 动态规划作业1 {
     Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new 动态规划作业1().fibonacci(15));
    }

    public  int fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;

        int x = map.containsKey(n - 1) ? map.get(n - 1) : fibonacci(n - 1);
        map.put(n - 1, x);
        int y = map.containsKey(n - 2) ? map.get(n - 2) : fibonacci(n - 2);
        map.put(n - 2, y);
        return x + y;
    }
}
