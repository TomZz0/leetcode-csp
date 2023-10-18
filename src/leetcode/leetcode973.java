package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wzh
 * @date 2023年09月25日 14:41
 * Description:
 */
public class leetcode973 {
    public static void main(String[] args) {
        int [][] arr = {{-5,4},{-6,-5},{4,6}};
        int k = 2;
        int[][] ints = kClosest(arr, k);
        System.out.println(123);
    }
    public static int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // return o2[0] - o1[0];
                return  (o2[0]*o2[0]+o2[1]*o2[1])-(o1[0]*o1[0]+o1[1]*o1[1]) ;
            }
        });
        for (int i=0;i<n;i++){
            int x = points[i][0];
            int y = points[i][1];
            if (q.size() == k){
                int[] peek = q.peek();
                if (x*x+y*y < peek[0]*peek[0]+peek[1]*peek[1]){
                    q.poll();
                    q.offer(points[i]);
                }
            }else {
                q.offer(points[i]);
            }
        }
        int[][] res = new int[k][2];
        for (int i=0;i<k;i++){
            res[i] = q.poll();
        }
        return res;
    }
}
