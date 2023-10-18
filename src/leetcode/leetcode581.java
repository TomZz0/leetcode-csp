package leetcode;

import java.util.Arrays;

/**
 * @author wzh
 * @date 2023年10月04日 10:53
 * Description:
 */
public class leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int right = n-1;
        int left = 0;
        for (int i=0;i<n;i++){
            if (nums[i] > max){
                max = nums[i];
            }else {
                right = i;
            }
            if (nums[n-i-1] < min){
                min = nums[n-i-1];
            }else {
                left = n-i-1;
            }
        }
        return right==-1?0:right-left+1;
    }
}
