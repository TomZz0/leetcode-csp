package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wzh
 * @date 2023年10月03日 12:56
 * Description:
 */
public class leetcode435 {

    public static void main(String[] args) {
        int[][] arr = {{0,2}, {1,3},{2,4},{3,5},{4,6}};
        int i = new leetcode435().eraseOverlapIntervals(arr);
        System.out.println(i);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n==0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });
        int right = intervals[0][1];
        int res = 1;
        for(int i=1;i<n;i++){
            if(intervals[i][0] >= right){
                res++;right = intervals[i][1];
            }
        }
        return n-res;
    }

}
