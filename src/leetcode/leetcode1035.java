package leetcode;

import java.util.HashMap;

/**
 * @author wzh
 * @date 2023年09月11日 18:46
 * Description:
 */
public class leetcode1035 {
    public static void main(String[] args) {
        int[]arr1 = {1,4,2,3,6};
        int[]arr2 = {1,2,3,6,4};
        int i = new leetcode1035().maxUncrossedLines(arr1, arr2);
        System.out.println(i);
    }
    public  int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;int m = nums2.length;
        int len = n;
        int[]arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            Integer start = map.get(nums1[i]);
            if (start==null) start = 0;
            else start++;
            while (start < m){
                if (nums2[start] == nums1[i]){
                    map.put(nums1[i],start);
                    arr[i] = start;
                    break;
                }
                start++;
                if (start == m) {
                    arr[i] = -1;
                    len--;
                }
            }
        }
        int[] arrp = new int[len];
        len = 0;
        for (int i=0;i<n;i++){
            if (arr[i] != -1) arrp[len++] = arr[i];
        }

        n = arrp.length;
        int[]dp = new int[n];
        dp[0]=1;int res = 1;
        for(int i=1;i<n;i++){
            int max = 1;

            for (int j=0;j<i;j++){
                if (arrp[j] >= arrp[i]) continue;
                int cur = dp[j]+1;
                if (cur > max) max = cur;
            }
            dp[i] = max;
            if(max > res) res = max;
        }
        return res;
    }
}
