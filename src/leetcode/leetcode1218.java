package leetcode;

import java.util.HashMap;

/**
 * @author wzh
 * @date 2023年09月10日 10:38
 * Description:
 */
public class leetcode1218 {
    public static void main(String[] args) {
        int i = longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2);
        System.out.println(i);
    }
    public static int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int[]dp = new int[n];
        int res =1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int val = 1;
            if (map.containsKey(arr[i] - difference)){
                val = map.get(arr[i]-difference) + 1;
            }
            Integer x = map.get(arr[i]);
            if (x!=null){
                val = Math.max(x,val);
            }
            map.put(arr[i],val);
            res = Math.max(res,val);
        }
        return res;
    }
}
