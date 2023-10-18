package leetcode;

import java.util.*;

/**
 * @author wzh
 * @date 2023年10月13日 18:38
 * Description:
 */
public class leetcode310 {
    static List<Integer>[] list;
    static boolean[] vis;
    static List<Integer> res = new LinkedList<>();

    public static void main(String[] args) {
        int k = 4;
        int[][] arr = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> minHeightTrees = new leetcode310().findMinHeightTrees(k, arr);
        System.out.println(minHeightTrees.toString());
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        list = new List[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) list[i] = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            int[] temp = edges[i];
            list[temp[0]].add(temp[1]);
            list[temp[1]].add(temp[0]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int high = dfs(i, edges, 0);
            if (min > high){
                res.clear();
                res.add(i);
                min = high;
            }else if (min==high) res.add(i);
            Arrays.fill(vis, false);
        }
        return res;
    }

    private int dfs(Integer integer, int[][] edges, int height) {
        height++;
        List<Integer> curList = list[integer];
        vis[integer] = true;
        int res = height;
        for (Integer num : curList) {
            if (vis[num]) continue;
            res = Math.max(res, dfs(num, edges, height));
        }
        return res;
    }
}
