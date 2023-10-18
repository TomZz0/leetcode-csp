package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzh
 * @date 2023年10月10日 12:07
 * Description:
 */
public class leetcode210 {
    public static void main(String[] args) {
        int[][]arr = {{1,0},{2,0},{3,1},{3,2}};
        int x = 4;
        int[] order = new leetcode210().findOrder(x, arr);
        System.out.println(Arrays.toString(order));
    }
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    LinkedList<Integer> res = new LinkedList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (res.size()!=numCourses)return new int[0];
        int[] resA = new int[numCourses];
        int index = 0;
        for (Integer integer:res){
            resA[index++] = integer;
        }
        return resA;
    }
    public void dfs(int u) {
        visited[u] = 1;

        for(int v:edges.get(u)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid) return;
            }else if(visited[v] == 1){
                valid =false;
                return ;
            }
        }
        res.offerLast(u);
        visited[u]= 2;
    }
}
