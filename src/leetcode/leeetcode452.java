package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wzh
 * @date 2023年10月04日 9:31
 * Description:
 */
public class leeetcode452 {

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {4, 5}, {1, 5}};
        int minArrowShots = new leeetcode452().findMinArrowShots(arr);
        System.out.println(minArrowShots);
    }

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 1) return 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? ((long) o1[0] - o2[0]) > 0 ? 1 : -1:((long) o1[1] - o2[1]) > 0 ? 1 : -1;
            }
        });
        int res = 0;
        int i = 1;
        int right = points[0][1];
        int left = points[0][0];
        while (i < n) {
            if (points[i][0] <= right && points[i][0] >= left && points[i][1] <= right && points[i][1] >= left){
                left = points[i][0];right = points[i][1];res++;
            }else if(points[i][0] <= right && points[i][0] >= left) {
                left = points[i][0];res++;
            }else if (points[i][1] <= right && points[i][1] >= left){
                right = points[i][1];   res++;
            }else {
                left = points[i][0];right = points[i][1];res++;
            }
            i++;
        }
        return res;
    }
}
