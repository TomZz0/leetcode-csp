package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzh
 * @date 2023年10月09日 14:27
 * Description:
 */
public class leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        boolean[] vis = new boolean[n];
        Arrays.sort(prerequisites, (x, y) -> x[0] - y[0]);
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            boolean res = dfs(i, prerequisites, new LinkedList<>(), vis);
            if (!res) return res;
        }
        return true;
    }

    private boolean dfs(int i, int[][] prerequisites, LinkedList<Integer> list, boolean[] vis) {
        if (!vis[i]) {
            int t = prerequisites[i][1];
            if (list.contains(t)) return false;
            list.offerLast(prerequisites[i][0]);
            vis[i] = true;
            int p = find(prerequisites, t);
            if (p==-1) return true;
            boolean res = dfs(p, prerequisites, new LinkedList<>(list), vis);
            if (!res) return false;
            list.pollLast();
        }
        return true;
    }

    private int find(int[][] prerequisites, int t) {
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == t) return i;
        }
        return -1;
    }

}
